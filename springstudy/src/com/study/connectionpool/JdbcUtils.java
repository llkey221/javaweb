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
	 * @Description 释放资源 
	 * @author Richard
	 * @param conn
	 * @param st
	 * @param rs
	 */
	public static void release(Connection conn,Statement st,ResultSet rs ){
		if(rs!=null){
			try{
				//关闭存储查询结果的ResultSet对象
				rs.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		if(st!=null){
			try{
				//关闭负责执行数据库Sql语句的Statementct对象
				st.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		if(conn!=null){
			try{
				//关闭Connection数据库连接对象
				conn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	public static void Main(String[] args) {
		
	}
}
