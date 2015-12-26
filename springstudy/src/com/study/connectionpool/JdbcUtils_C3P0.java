package com.study.connectionpool;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * @className:JdbcUtils_C3P0
 * @description:��Դ��� C3P0����Դ������
 * @author Administrator
 *
 */
public class JdbcUtils_C3P0 {
	private static ComboPooledDataSource ds=null;
	
	static{
		try {
			// ͨ�����봴��C3P0���ݿ����ӳ�
			/*
			 * ds = new ComboPooledDataSource();
			 * ds.setDriverClass("com.mysql.jdbc.Driver");
			 * ds.setJdbcUrl("jdbc:mysql://localhost:3306/jdbcstudy");
			 * ds.setUser("root"); ds.setPassword("XDP");
			 * ds.setInitialPoolSize(10); ds.setMinPoolSize(5);
			 * ds.setMaxPoolSize(20);
			 */

			// ��ȡĬ�ϵ�����Դ����
			// ds= new ComboPooledDataSource();
			ds = new ComboPooledDataSource("MySql"); // ʹ��c3p0��������������������Դ
		} catch (Exception e) {
			throw new ExceptionInInitializerError(e);
		}	 
	}
	
	/**
	 * @Method��������Դ�л������
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException{
		//������Դ�л�ȡ���ݿ�����
		return ds.getConnection();
	}
	
	/**
	 * @methodName:release
	 * @description:�ͷ����ݿ����ӡ�ִ���������ݼ�
	 * @author Richard
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
				//�����ݿ����ӣ��������ݿ����ӳ�
				conn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}
