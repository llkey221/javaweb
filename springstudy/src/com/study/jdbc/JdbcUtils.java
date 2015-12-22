package com.study.jdbc;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtils {
	
	
	public static String driver=null;
	public static String url=null;
	public static String username=null;
	public static String password=null;
	
	/**
	 * �����ʱ��ʼ�����ݿ�Driver���û���������
	 * 
	 */
	static{
		try{
			InputStream in=JdbcUtils.class.getClassLoader().getResourceAsStream("db1.properties");
			
			Properties prop=new Properties();
			prop.load(in);
			
			driver=prop.getProperty("driver");
			url=prop.getProperty("url");
			username=prop.getProperty("username");
			password=prop.getProperty("password");
			
			Class.forName(driver);
			
		}catch(Exception e){
			throw new ExceptionInInitializerError(e);
		}
	}
	
	/**
	 * ��ȡ���ݿ�����
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException{
//		DriverManager
		return DriverManager.getConnection(url,username,password);
	}
	
	/**
	 * �ͷ���Դ
	 * �ر����ݿ�����
	 * 
	 * @param conn
	 * @param st
	 * @param rs
	 */
	public static void release(Connection conn,Statement st,ResultSet rs){
		if(rs!=null){
			try{
				rs.close();
			}catch(Exception e){
				e.printStackTrace();
			}
			rs=null;
		}
		
		if(st!=null){
			try{
				st.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		if(conn!=null){
			try{
				conn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}
