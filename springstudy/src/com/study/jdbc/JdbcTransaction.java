package com.study.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;

public class JdbcTransaction {
	
	/**
	 * ����jdbc����
	 */
	public void TransferAccount(){
		
		Connection conn=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		
		try {
			conn = JdbcUtils.getConnection();
			conn.setAutoCommit(false);
			
			String sqlTranfer="update account set money=money-50 where name='a'";
			String sqlReceive="update account set money=money+50 where name='b'";
			st=conn.prepareStatement(sqlTranfer);
			st.executeUpdate();
			
			st=conn.prepareStatement(sqlReceive);
			st.executeUpdate();
			
			conn.commit();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally{
			JdbcUtils.release(conn, st, rs);
		}	
	}
	
	/**
	 * ��������ع���
	 */
	public void SavaRollbackPoint(){
		Connection conn=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		Savepoint sp=null;
		
		try {
			conn=JdbcUtils.getConnection();
			conn.setAutoCommit(false);
			String sql="update account set money=money-50 where name='c'";			
			st=conn.prepareStatement(sql);
			st.executeUpdate();
			//��������ع��㣬�ع�����ǰ����䲻�ٻع�
			//�������һ��Ҫ�ύ���� 
			sp=conn.setSavepoint();
			
			String sql2="update account set money=money+80 where name='a'";
			st=conn.prepareStatement(sql2);
			st.executeUpdate();
			
			int i=1/0;
			
			String sql3="update account set money=money-80 where name='b'";
			st=conn.prepareStatement(sql2);
			st.executeUpdate();
			
			conn.commit();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			try {
				conn.rollback(sp);	//�ع����õ�����ع���
				conn.commit();		//�ύ������ 
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally{
			JdbcUtils.release(conn, st, rs);
		}

		
	}
}
