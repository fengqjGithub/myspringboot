package com.joy.java.util.net;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.service.IoConnector;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

import java.net.InetSocketAddress;

/**
 * tcp客户端。依赖于mina-core-2.0.7.jar,slf4j-api-1.6.6.jar.
 * 生成客户端时，实现这个抽象类即可。
 */
public abstract class AbstractTcpClient extends IoHandlerAdapter{
	 /** The connector */
    protected IoConnector connector;

    /** The session */
    protected static IoSession session;

    /**
     * Create the UdpClient's instance
     */
    public AbstractTcpClient() {
        connector = new NioSocketConnector();
        connector.setHandler(this);
        ConnectFuture connFuture = connector.connect(new InetSocketAddress(getServerIp(), getServerPort()));
        connFuture.awaitUninterruptibly();
        session = connFuture.getSession();
    }
    
    /**
     * 功能：向服务端传送数据。
     * @param str
     */
    public void write(String str){
		IoBuffer buffer = IoBuffer.allocate(str.getBytes().length);
        buffer.put(str.getBytes());
        buffer.flip();
		write(buffer);
    }
    
    /**
     * 功能：向服务端传送数据。
     * @param buffer
     */
    public void write(IoBuffer buffer){
    	 session.write(buffer);
    }
    
    /**
     * 功能：传入服务端的IP。
     * @return String
     */
    public abstract String getServerIp() ;
    
    /**
     * 功能：传入服务端的端口。
     * @return int
     */
    public abstract int getServerPort() ;

   /**
    * 出现异常时。
    */
    @Override
    public abstract void exceptionCaught(IoSession session, Throwable cause) throws Exception ;

    /**
     * 收到报文返回时。
     */
    @Override
    public abstract void messageReceived(IoSession session, Object message) throws Exception ;

    /**
     * 发送报文后。
     */
    @Override
    public abstract void messageSent(IoSession session, Object message) throws Exception ;

    /**
     * {@inheritDoc}
     */
    @Override
    public abstract void sessionClosed(IoSession session) throws Exception ;

    /**
     * session创建时。
     */
    @Override
    public abstract void sessionCreated(IoSession session) throws Exception ;

    /**
     * session超时时。
     */
    @Override
    public abstract void sessionIdle(IoSession session, IdleStatus status) throws Exception ;

    /**
     * session打开时。
     */
    @Override
    public abstract void sessionOpened(IoSession session) throws Exception ;

}
