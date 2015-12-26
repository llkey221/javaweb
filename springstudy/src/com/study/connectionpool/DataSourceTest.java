package com.study.connectionpool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.jdbc.Statement;

public class DataSourceTest {
	
	private static DataSourceTest dsTest=new DataSourceTest();
	
	public int dbcpDataSourceTest(){
		Connection conn=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		int id=-1;
		try{
			conn=JdbcUtils_BDCP.getConnection();
			String sql="insert into test1(name) values(?)";
			st=conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			st.setString(1, "Richard");
			st.executeUpdate();
			rs=st.getGeneratedKeys();
			
			if(rs.next()){
				id=rs.getInt(1);
				System.out.println("插入记录的ID为："+id);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			//释放资源 
			JdbcUtils_BDCP.release(conn, st, rs);
		}
		return id;
	}
	
	public void c3p0DataSourceTest(int id){
		Connection conn=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		try{
			conn=JdbcUtils_C3P0.getConnection();
			String sql="select name from test1 where id=?";			
			st=conn.prepareStatement(sql);
			st.setInt(1, id);
			
			rs=st.executeQuery();
			if(rs.next()){
				System.out.println("刚插入的数据的Name="+rs.getString("name"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JdbcUtils_C3P0.release(conn, st, rs);
		}
	}
	
	/**
	 * 测试JNDI数据源
	 */
	public void JNDIDataSourceTest(){
		Connection conn=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		try{
			conn=JdbcUtils_JNDI.getConnection();
			String sql="select id,name from test1";
			st=conn.prepareStatement(sql);
			
			rs=st.executeQuery();
			System.out.println("用户列表如下：");
			while(rs.next()){
				System.out.print("id="+rs.getInt("id")+"\t\t");
				System.out.println("name="+rs.getString("name"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JdbcUtils_JNDI.release(conn, st, rs);			
		}
	}
	
	public static void main(String[] args) {
		int id=dsTest.dbcpDataSourceTest();
		
		dsTest.c3p0DataSourceTest(id);
		
	}
}
