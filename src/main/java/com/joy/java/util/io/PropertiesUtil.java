package com.joy.java.util.io;

import com.joy.java.util.lang.StringUtil;

import java.io.*;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 读取Properties 默认classpath下的config.properties文件�?
 */
public class PropertiesUtil {
	//配置文件的路径
	private String configPath=null;
	private static String OS = System.getProperty("os.name").toLowerCase();
	
	/**
	 * 配置文件对象
	 */
	private Properties props=null;

	/**
	 * @param fileName 配置文件名称
	 */
	public PropertiesUtil(String fileName) throws IOException{
		String propertiesUtilPath=PropertiesUtil.class.getResource("PropertiesUtil.class").getPath();
		//截取路径到classes
		String classPath=propertiesUtilPath.substring(0,propertiesUtilPath.indexOf("WEB-INF/"))+"WEB-INF/classes/";
		//在mac或者Linux下开头有file:,去掉
		classPath= StringUtil.removeStart(classPath,"file:");
		//判断Linux window
		if(OS.indexOf("window")>-1) {
			configPath = classPath.substring(1) + fileName;
		}else{
			configPath = classPath + fileName;
		}
		props = new Properties();
		InputStream in = new BufferedInputStream(new FileInputStream(configPath));
		props.load(in);
		//关闭资源
		in.close();
		propertiesUtilPath=null;
		classPath=null;
	}
	
	/**
	 * 默认构造函数，用于sh运行，自动找到classpath下的config.properties�?
	 */
	public PropertiesUtil() throws IOException{
		String propertiesUtilPath=PropertiesUtil.class.getResource("PropertiesUtil.class").getPath();
		//截取路径到classes
		String classPath=propertiesUtilPath.substring(0,propertiesUtilPath.indexOf("WEB-INF/"))+"WEB-INF/classes/";
		//在mac或者Linux下开头有file:,去掉
		classPath= StringUtil.removeStart(classPath,"file:");
		//判断Linux window
		if(OS.indexOf("window")>-1) {
			configPath = classPath.substring(1) + "config.properties";
		}else{
			configPath = classPath + "config.properties";
		}
		props = new Properties();
		InputStream in = new BufferedInputStream(new FileInputStream(configPath));
		props.load(in);
		//关闭资源
		in.close();
		propertiesUtilPath=null;
		classPath=null;
	}
	
	/**
	 * 根据key值读取配置的�?
	 * Jun 26, 2010 9:15:43 PM
	 * @return key 键对应的�?
	 * @throws IOException
	 */
	public String readValue(String key) throws IOException {
		return  props.getProperty(key);
	}

	/**
	 * 读取properties的全部信�?
	 * Jun 26, 2010 9:21:01 PM
	 * @throws FileNotFoundException 配置文件没有找到
	 * @throws IOException 关闭资源文件，或者加载配置文件错�?
	 * 
	 */
	public Map<String,String> readAllProperties() throws FileNotFoundException,IOException  {
		//保存�?��的键�?
		Map<String,String> map=new HashMap<String,String>();
		Enumeration en = props.propertyNames();
		while (en.hasMoreElements()) {
			String key = (String) en.nextElement();
			String Property = props.getProperty(key);
			map.put(key, Property);
		}
		return map;
	}

	/**
	 * 得到某一个类的路�?
	 * @param name
	 * @return
	 */
	private String getPath(Class name) {
		String strResult = null;
		if (System.getProperty("os.name").toLowerCase().indexOf("window") > -1) {
			strResult = name.getResource("/").toString().replace("file:/", "")
					.replace("%20", " ");
		} else {
			strResult = name.getResource("/").toString().replace("file:", "")
					.replace("%20", " ");
		}
		return strResult;
	}
	
//	/**
//	 * 设置某个key的�?,并保存至文件�?
//	 * Jun 26, 2010 9:15:43 PM
//	 * @param key 键对应的�?
//	 * @param note 备注信息
//	 * @throws IOException 
//	 */
//	public void setValue(String key,String value,String note) throws IOException {
//		Properties prop = new Properties();
//		try {
//			InputStream fis = new FileInputStream(this.configPath);
//			// 从输入流中读取属性列表（键和元素对）
//			prop.load(fis);
//			// 调用 Hashtable 的方�?put。使�?getProperty 方法提供并行性�?
//			// 强制要求为属性的键和值使用字符串。返回�?�?Hashtable 调用 put 的结果�?
//			OutputStream fos = new FileOutputStream(this.configPath);
//			prop.setProperty(key, value);
//			// 以�?合使�?load 方法加载�?Properties 表中的格式，
//			// 将此 Properties 表中的属性列表（键和元素对）写入输出�?
//			prop.store(fos,note);
//			//关闭文件
//			fis.close();
//			fos.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
}
