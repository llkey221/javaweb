package com.study.connectionpool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.MessageFormat;

public class PoolTest {
	
	private static PoolTest testPool=new PoolTest();
	
	public void Update(){
		String sql="update pool set name=? where name=?";
		Connection conn=null;
		PreparedStatement st=null;
		try {
			conn=JdbcUtils.getConnection();
			st=conn.prepareStatement(sql);
			st.setString(1, "Richard");
			st.setString(2, "llkey");
			
			int count=st.executeUpdate();
			if(count>0){
				System.out.println(MessageFormat.format("共影响{0}行", count));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtils.release(conn, st, null);
		}
	}
	
	public void Insert(){
		String sql="insert into pool(name) values(?)";
		Connection conn=null;
		PreparedStatement st=null;
		try {
			conn=JdbcUtils.getConnection();
			st=conn.prepareStatement(sql);
			st.setString(1, "Tang Hua");
			
			int count=st.executeUpdate();
			if(count>0){
				System.out.println(MessageFormat.format("共影响{0}行", count));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtils.release(conn, st, null);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testPool.Update();
		testPool.Insert();
		testPool.Update();
	}

}
