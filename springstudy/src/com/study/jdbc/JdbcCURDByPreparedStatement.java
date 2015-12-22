package com.study.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.sql.Date;

public class JdbcCURDByPreparedStatement {
	
	
	public static void Insert(){
		Connection conn=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		
		try{
			conn=JdbcUtils.getConnection();
			String sql="insert into employee(id,name,password,email,birthday) values(?,?,?,?,?)";
			st=conn.prepareStatement(sql);
			
			st.setInt(1,5);
			st.setString(2, "Tang");
			st.setString(3, "6666");
			st.setString(4, "tang@hotmail.com");
			st.setDate(5, new Date(90, 8, 8));
			
			int count=st.executeUpdate();
			if(count>0){
				System.out.println("Execute update PreparedStatement Success!");
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			JdbcUtils.release(conn, st, rs);
		}
	}
	
	public static void Query(){
		Connection conn=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		
		try{
			conn=JdbcUtils.getConnection();
			String sql="select * from employee where id=?";
			st=conn.prepareStatement(sql);
			st.setInt(1, 4);
			
			rs=st.executeQuery();
			while(rs.next()){
				int id=rs.getInt("id");
				String name=rs.getString("name");
				String password=rs.getString("password");
				String email=rs.getString("email");
				
				SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
				java.util.Date birthday=df.parse(rs.getString("birthday"));
				
				System.out.println(MessageFormat.format("执行查询结果如下：\nid={0} name={1} password={2} email={3} birthday={4}", 
						id,name,password,email,df.format(birthday)));
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			JdbcUtils.release(conn, st, rs);
		}
	}
	
	public static void BatchSql(){
		
		long startTime=System.currentTimeMillis();
		Connection conn=null;
		PreparedStatement st=null;
		
		try {
			conn = JdbcUtils.getConnection();

			String sql = "insert into testbatch(name) values(?)";
			st = conn.prepareStatement(sql);
			
			for(int i=1;i<=100;i++){
				st.setString(1, "Richard");
				st.addBatch();
				if(i%10==0){
					st.executeBatch();
					st.clearBatch();
				/*	ResultSet rs=st.getGeneratedKeys();
					while (rs.next()){
						System.out.println(rs.getInt(1));
					}
					rs.close();*/
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JdbcUtils.release(conn, st, null);
		}
		long endTime=System.currentTimeMillis();
		
		System.out.println("Application Spend "+(endTime-startTime)/1000+"秒" );
		
	}
	
	
	
}
