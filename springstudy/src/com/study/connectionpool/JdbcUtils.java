package com.study.connectionpool;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtils {
	private static JdbcPool pool=new JdbcPool();
	
	public static Connection getConnection() throws SQLException{
		return pool.getConnection();
	}
	
	/**
	 * @method release
	 * @Description �ͷ���Դ 
	 * @author Richard
	 * @param conn
	 * @param st
	 * @param rs
	 */
	public static void release(Connection conn,Statement st,ResultSet rs ){
		if(rs!=null){
			try{
				//�رմ洢��ѯ�����ResultSet����
				rs.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		if(st!=null){
			try{
				//�رո���ִ�����ݿ�Sql����Statementct����
				st.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		if(conn!=null){
			try{
				//�ر�Connection���ݿ����Ӷ���
				conn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	public static void Main(String[] args) {
		
	}
}
