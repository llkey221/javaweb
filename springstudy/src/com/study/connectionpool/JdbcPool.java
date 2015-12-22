package com.study.connectionpool;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.LinkedList;
import java.util.Properties;
import java.util.logging.Logger;

import javax.sql.DataSource;

public class JdbcPool implements DataSource{
	
	private static LinkedList<Connection> listConnections=new LinkedList<Connection>();
	
	static{
		
		InputStream in=JdbcPool.class.getClassLoader().getResourceAsStream("db.properties");
		Properties prop=new Properties();
		try {
			prop.load(in);
			String driver=prop.getProperty("driver");
			String url=prop.getProperty("url");
			String username=prop.getProperty("username");
			String password=prop.getProperty("password");
			
			int jdbcPoolInitSize=Integer.parseInt(prop.getProperty("jdbcPoolInitSize"));
			
			Class.forName(driver);
			
			for(int i=0;i<jdbcPoolInitSize;i++){
				Connection conn=DriverManager.getConnection(url,username,password);
				System.out.println("获取到了链接"+conn);
				//获取一定数量的数据库链接到链表中，作为一个池子
				listConnections.add(conn);
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public Connection getConnection() throws SQLException{
		if(listConnections.size()>0){
			final Connection conn=listConnections.removeFirst();
			System.out.println("listConnections数据库链接池的大小是："+listConnections.size());
			
			return (Connection) Proxy.newProxyInstance(JdbcPool.class.getClassLoader(), conn.getClass().getInterfaces(),
					new InvocationHandler() {
						public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
							if (!method.getName().equals("close")) {
								return method.invoke(conn, args);
							} else {
								listConnections.add(conn);
								System.out.println(conn + "还给数据库链接池listConnections了");
								System.out.println("listConnections数据库链接池的大小是：" + listConnections.size());
								return null;
							}
						}
					});
		}else{
			throw new RuntimeException("对不起，数据库忙！");
		}
	}
	
	@Override
	public Connection getConnection(String username,String password)
			throws SQLException {
		return null;
	}

	@Override
	public PrintWriter getLogWriter() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLogWriter(PrintWriter out) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLoginTimeout(int seconds) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getLoginTimeout() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}
}
