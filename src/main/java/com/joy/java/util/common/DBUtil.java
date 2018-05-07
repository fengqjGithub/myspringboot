package com.joy.java.util.common;

import org.apache.commons.dbcp.ConnectionFactory;
import org.apache.commons.dbcp.DriverManagerConnectionFactory;
import org.apache.commons.dbcp.PoolableConnectionFactory;
import org.apache.commons.dbcp.PoolingDriver;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.pool.ObjectPool;
import org.apache.commons.pool.impl.GenericObjectPool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 连接数据库的综合类。commons.dbcp-1.4，commons.dbutils-1.3，commons.pool-1.5.4包需要。
 */
public class DBUtil {
	
	private String dri = null;
	private String url = null;
	private String username = null;
	private String password = null;
	private String poolName = null;	//连接池名称
	private ObjectPool connectionPool = null; //连接池
	//取出时检查连接是否有效。
	private boolean testOnBorrow=true;
    //保存连接池
    private static Map<String,DBUtil> dbUtilMap=new HashMap<String,DBUtil>();
    //保存连接池信息,key 连接池名称 value url+userName
    private static Map<String,String> dbInfoMap=new HashMap<String,String>();
	
	/**
	 * 功能：获取一个DBUtil对象。若连接池名称相同，且url、用户名相同，直接返回直接创建的对应DBUtil。
     * 若连接池名称相同，但url、用户名任一个不同，则抛出RuntimeException异常。
	 * @param dri 驱动全类名，例如：com.mysql.jdbc.Driver。
	 * @param url 数据库url连接，例如："jdbc:mysql://127.0.0.1:3306/test?autoReconnect=true&amp;useUnicode=true&amp;characterEncoding=UTF-8"
	 * @param userName 数据库用户名，例如：root
	 * @param password 数据库密码，例如：abc
	 * @param poolName 创建的数据库连接池的名称，例如mypool，注意一个web容器此名称不能重复。
	 */
	public static DBUtil getInstance(String dri,String url,String userName,String password,String poolName) {
        //连接信息
        String infoValue=url+"-"+userName;
        if(dbUtilMap.containsKey(poolName)){
            //连接池名称存在但是连接信息不同
            if(!infoValue.equals(dbInfoMap.get(poolName))) {
                throw new RuntimeException("连接池" + poolName + "已存在！创建不同连接的连接池名称不能重复。");
            }else{
                //连接信息相同直接返回该连接池
                return dbUtilMap.get(poolName);
            }
        }
        DBUtil dbUtil=new DBUtil( dri, url, userName, password, poolName);
        dbUtilMap.put(poolName,dbUtil);
        dbInfoMap.put(poolName,infoValue);
		return dbUtil;
	}


	/**
	 * 功能：构造函数
	 * @param dri 驱动全类名，例如：com.mysql.jdbc.Driver。
	 * @param url 数据库url连接，例如："jdbc:mysql://127.0.0.1:3306/test?autoReconnect=true&amp;useUnicode=true&amp;characterEncoding=UTF-8"
	 * @param userName 数据库用户名，例如：root
	 * @param password 数据库密码，例如：abc
	 * @param poolName 创建的数据库连接池的名称，例如mypool，注意一个web容器此名称不能重复。
	 */
	private  DBUtil(String dri,String url,String userName,String password,String poolName){
		this.dri=dri;
		this.url=url;
		this.username=userName;
		this.password=password;
		this.poolName=poolName;
	}

    /**
     * 根据连接池名称得到连接
     * @param poolName 连接池名称
     * @return DBUtil
     */
    public static DBUtil getDbUtilByPoolName(String poolName) {
        return dbUtilMap.get(poolName);
    }

    /**
     * 根据连接池名称得到连接信息
     * @param poolName 连接池名称
     * @return String 连接url-用户名
     */
    public static String getDbInfoByPoolName(String poolName) {
        return dbInfoMap.get(poolName);
    }
	
	/**
	 * 执行sql。
	 * @param conn 连接
	 * @param pstm PreparedStatement
	 * @return int 执行sql对应的影响行。
	 * @throws SQLException 
	 */
	public int execute(Connection conn,PreparedStatement pstm) throws SQLException {
		try {
			return pstm.executeUpdate();
		}  finally {
			Close(conn);
		}
	}

    /**
     * 查询sql语句。
     * @param sql 被执行的sql语句
     * @param cls 查询出来的bean类信息。
     * @return List<T>
     * @throws SQLException
     */
    public <T> List<T> query(String sql,Class<T> cls) throws SQLException {
        List<T> results = null;
        Connection conn = null;
        try {
            conn = getConnection();
            QueryRunner qr = new QueryRunner();
            BeanListHandler<T> beanListHandler = new BeanListHandler(cls);
            results =qr.query(conn, sql, beanListHandler);
        }  finally {
            Close(conn);
        }
        return results;
    }

    /**
     * 查询sql语句。
     * @param sql 被执行的sql语句
     * @param cls 查询出来的bean类信息。
     * @param param 参数
     * @return List<T>
     * @throws SQLException
     */
    public <T> List<T> query(String sql,Class<T> cls,Object... param) throws SQLException {
        List<T> results = null;
        Connection conn = null;
        try {
            conn = getConnection();
            QueryRunner qr = new QueryRunner();
            BeanListHandler<T> beanListHandler = new BeanListHandler(cls);
            results =qr.query(conn, sql, beanListHandler,param);
        }  finally {
            Close(conn);
        }
        return results;
    }


	/**
	 * 查询sql语句。
	 * @param sql 被执行的sql语句
	 * @return List<Map<String,Object>>
	 * @throws SQLException 
	 */
	public List<Map<String,Object>> query(String sql) throws SQLException {
		List<Map<String,Object>> results = null;
		Connection conn = null;
		try {
			conn = getConnection();
			QueryRunner qr = new QueryRunner();
			results =qr.query(conn, sql, new MapListHandler());
		}  finally {
			Close(conn);
		}
		return results;
	}
	
	/**
	 * 查询sql语句。
	 * @param sql 被执行的sql语句
	 * @return Object[]
	 * @throws SQLException 
	 */
	public Object[] query4Objects(String sql) throws SQLException {
		Object[] results = null;
		Connection conn = null;
		try {
			conn = getConnection();
			QueryRunner qr = new QueryRunner();
			results =qr.query(conn, sql, new ArrayHandler());
		}  finally {
			Close(conn);
		}
		return results;
	}
	
	/**
	 * 根据参数查询sql语句
	 * @param sql sql语句
	 * @param param 参数数组
	 * @return List<Map<String,Object>>
	 * @throws SQLException 
	 */
	public List<Map<String,Object>> query(String sql, Object... param) throws SQLException {
		List<Map<String,Object>> results = null;
		Connection conn = null;
		try {
			conn = getConnection();
			QueryRunner qr = new QueryRunner();
			results = (List<Map<String,Object>>) qr.query(conn, sql, param, new MapListHandler());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Close(conn);
		}
		return results;
	}

	/**
	 * 执行sql语句
	 * @param sql 被执行的sql语句
	 * @return 受影响的行
	 * @throws Exception
	 */
	public int execute(String sql) throws Exception {
		Connection conn = getConnection();
		int rows = 0;
		try {
			QueryRunner qr = new QueryRunner();
			rows = qr.update(conn, sql);
		} finally {
			Close(conn);
		}
		return rows;
	}

	/**
	 * 执行含参数的sql语句
	 * @param sql 被执行的sql语句
	 * @param params 参数
	 * @return 返回受影响的行
	 * @throws Exception
	 */
	public int execute(String sql, Object[] params) throws Exception {
		Connection conn = getConnection();
		int rows = 0;
		try {
			QueryRunner qr = new QueryRunner();
			rows = qr.update(conn, sql, params);
		} finally {
			Close(conn);
		}
		return rows;
	}

	/**
	 * 关闭连接
	 * @param conn
	 * @throws SQLException 
	 */
	public void Close(Connection conn) throws SQLException {
		if(conn!=null){
			conn.close();
		}
		DbUtils.closeQuietly(conn);
	}
	
	/**
	 * 启动连接池
	 */
	private void StartPool() {
		try {
			Class.forName(dri);
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		if (connectionPool != null) {
			ShutdownPool();
		}
		try {
			GenericObjectPool.Config config = new GenericObjectPool.Config();  
			//取出时检查连接是否有效。
			config.testOnBorrow=testOnBorrow;
	        
			connectionPool = new GenericObjectPool(null,config);
			ConnectionFactory connectionFactory = new DriverManagerConnectionFactory(
					url, username, password);
			PoolableConnectionFactory poolableConnectionFactory = new PoolableConnectionFactory(
					connectionFactory, connectionPool, null, "SELECT 1",
					false, true);
			Class.forName("org.apache.commons.dbcp.PoolingDriver");
			PoolingDriver driver = (PoolingDriver) DriverManager
					.getDriver("jdbc:apache:commons:dbcp:");
			driver.registerPool(poolName, poolableConnectionFactory.getPool());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 关闭连接池
	 */
	private void ShutdownPool() {
		try {
			PoolingDriver driver = (PoolingDriver) DriverManager
					.getDriver("jdbc:apache:commons:dbcp:");
			driver.closePool(poolName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 得到一个连接
	 * @return
	 */
	public synchronized Connection getConnection() {
		Connection conn = null;
		try {
			if (connectionPool == null)
				StartPool();
			conn = DriverManager.getConnection("jdbc:apache:commons:dbcp:"+poolName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	/**
	 * 取出时检查连接是否有效。
	 * @return
	 */
	public boolean isTestOnBorrow() {
		return testOnBorrow;
	}


	/**
	 * 设置取出时检查连接是否有效。
	 * @param testOnBorrow true 检测，false 不检测。
	 */
	public void setTestOnBorrow(boolean testOnBorrow) {
		this.testOnBorrow = testOnBorrow;
	}
}

