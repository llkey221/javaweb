package com.study.connectionpool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.jdbc.Statement;

public class DataSoureTest {
	
	private static DataSoureTest dsTest=new DataSoureTest();
	
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
				System.out.println("�����¼��IDΪ��"+id);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			//�ͷ���Դ 
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
				System.out.println("�ղ�������ݵ�Name="+rs.getString("name"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		int id=dsTest.dbcpDataSourceTest();
		
		dsTest.c3p0DataSourceTest(id);
		
	}
}
