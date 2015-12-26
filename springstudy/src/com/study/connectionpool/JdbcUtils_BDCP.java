package com.study.connectionpool;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSourceFactory;

/**
 * @ClassName:JdbcUtils_BDCP
 * @Description:数据库连接池工具
 * @author Richard
 *
 */
public class JdbcUtils_BDCP {
	
	private  static  DataSource ds=null;
	
	static{
	
		try {
			
			InputStream in= JdbcUtils_BDCP.class.getClassLoader().getResourceAsStream("dbcpconfig.properties");
			
			Properties prop=new Properties();
			
			prop.load(in);
			
			String daa=prop.getProperty("driverClassName");
			
			ds=BasicDataSourceFactory.createDataSource(prop);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new ExceptionInInitializerError(e);
		}catch(Throwable t){
			t.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException{
		return ds.getConnection();
	}
	
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
