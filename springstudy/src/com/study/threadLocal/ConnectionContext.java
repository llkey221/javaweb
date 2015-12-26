package com.study.threadLocal;

import java.sql.Connection;

public class ConnectionContext {
	/**
	 * ˽�л����캯��
	 */
	private ConnectionContext(){}
	
	/**
	 * �Լ�����ʵ�������Ϊ����
	 */
	private static ConnectionContext context=new ConnectionContext();
	
	/**
	 * ThreadLocal�������ݿ�����
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
