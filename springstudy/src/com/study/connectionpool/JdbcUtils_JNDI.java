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
			//初始化JNDI
			Context initCtx=new InitialContext();
			//得到JNDI窗口
			Context envCtx=(Context)initCtx.lookup("java:comp/env");
			//从JNDI窗口中检索name=jdbc/datasource的数据源
			ds=(DataSource) envCtx.lookup("jdbc/datasource");
		}catch(Exception e){
			throw new ExceptionInInitializerError(e);
		}catch(Throwable e){
			e.printStackTrace();
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
