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
	
	public static void main(String[] args) {
		dsTest.dbcpDataSourceTest();
	}
}
