package com.study.connectionpool;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * @className:JdbcUtils_C3P0
 * @description:开源组件 C3P0数据源工具类
 * @author Administrator
 *
 */
public class JdbcUtils_C3P0 {
	private static ComboPooledDataSource ds=null;
	
	static{
		try {
			// 通过代码创建C3P0数据库连接池
			/*
			 * ds = new ComboPooledDataSource();
			 * ds.setDriverClass("com.mysql.jdbc.Driver");
			 * ds.setJdbcUrl("jdbc:mysql://localhost:3306/jdbcstudy");
			 * ds.setUser("root"); ds.setPassword("XDP");
			 * ds.setInitialPoolSize(10); ds.setMinPoolSize(5);
			 * ds.setMaxPoolSize(20);
			 */

			// 读取默认的数据源配置
			// ds= new ComboPooledDataSource();
			ds = new ComboPooledDataSource("MySql"); // 使用c3p0的命名配置来创建数据源
		} catch (Exception e) {
			throw new ExceptionInInitializerError(e);
		}	 
	}
	
	/**
	 * @Method：从数据源中获得连接
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException{
		//从数据源中获取数据库连接
		return ds.getConnection();
	}
	
	/**
	 * @methodName:release
	 * @description:释放数据库连接、执行语句和数据集
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
				//将数据库连接，还给数据库连接池
				conn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}
