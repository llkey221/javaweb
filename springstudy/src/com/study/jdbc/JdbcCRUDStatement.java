package com.study.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JdbcCRUDStatement {
	
	public static void Insert() {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;

		try {
			conn = JdbcUtils.getConnection();
			String sql = "insert into employee values(3,'tian','123456','llkey221@126.com','1990-08-08')";

			st = conn.createStatement();
			int count = st.executeUpdate(sql);
			if (count > 0) {
				System.out.println("Sql Insert Statement 执行成功。");
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			JdbcUtils.release(conn, st, rs);
		}
	}
	
	public static void Update() {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;

		try {
			conn = JdbcUtils.getConnection();
			st = conn.createStatement();
			String sql = "update employee set password='111111' where id=3";
			int count = st.executeUpdate(sql);
			if (count > 0) {
				System.out.println("Sql Update Statement执行成功。");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			JdbcUtils.release(conn, st, rs);
		}
	}
	
	public static void Query() {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			conn=JdbcUtils.getConnection();
			st=conn.createStatement();
			String sql="select * from employee where id=3";
			rs=st.executeQuery(sql);
			
			while(rs.next()){
				int id=rs.getInt("id");
				String name=rs.getString("name");
				String password=rs.getString("password");
				String email=rs.getString("email");
				
				SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
				Date birthday=df.parse(rs.getString("birthday"));
				
				System.out.println(MessageFormat.format("执行查询结果如下：\nid={0} name={1} password={2} email={3} birthday={4}", 
						id,name,password,email,df.format(birthday)));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtils.release(conn, st, rs);
		}
	}
	
	public static void Delete(){
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			conn=JdbcUtils.getConnection();
			st=conn.createStatement();
			String sql="delete from employee where id=3";
			int count=st.executeUpdate(sql);
			
			if(count>0){
				System.out.println("sql delete statement 操作成功。");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtils.release(conn, st, rs);
		}
	}
	
	public static void BatchSql(){
		Connection conn=null;
		Statement st=null;
		
		try{
			conn=JdbcUtils.getConnection();
			st=conn.createStatement();
			st.addBatch("insert into employee values(9,'hua','666','hua@126.com','1990-08-10')");
			st.addBatch("insert into employee values(10,'hua','666','hua@126.com','1990-08-10')");
			st.addBatch("insert into employee values(11,'hua','666','hua@126.com','1990-08-10')");
			st.addBatch("insert into employee values(12,'hua','666','hua@126.com','1990-08-10')");
			
			st.executeBatch();
			st.clearBatch();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JdbcUtils.release(conn, st, null);
		}
		
		
	}
}
