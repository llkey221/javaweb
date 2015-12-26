package com.study.connectionpool;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class JdbcUtils_JNDI {
	private static DataSource ds=null;
	
	static{
		try{
			//��ʼ��JNDI
			Context initCtx=new InitialContext();
			//�õ�JNDI����
			Context envCtx=(Context)initCtx.lookup("java:comp/env");
			//��JNDI�����м���name=jdbc/datasource������Դ
			ds=(DataSource) envCtx.lookup("jdbc/datasource");
		}catch(Exception e){
			throw new ExceptionInInitializerError(e);
		}catch(Throwable e){
			e.printStackTrace();
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
