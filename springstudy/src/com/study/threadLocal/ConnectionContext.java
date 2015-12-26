package com.study.threadLocal;

import java.sql.Connection;

public class ConnectionContext {
	/**
	 * 私有化构造函数
	 */
	private ConnectionContext(){}
	
	/**
	 * 自己创建实例，设计为单例
	 */
	private static ConnectionContext context=new ConnectionContext();
	
	/**
	 * ThreadLocal保存数据库连接
	 */
	private ThreadLocal<Connection> threadLocalConn=new ThreadLocal<Connection>();
	
	public static ConnectionContext getInstance(){
		return context;
	}
	
	public void bind(Connection conn){
		threadLocalConn.set(conn);
	}
	
	public Connection getConnection(){
		return threadLocalConn.get();
	}
	
	public void remove(){
		threadLocalConn.remove();
	}
	
}
