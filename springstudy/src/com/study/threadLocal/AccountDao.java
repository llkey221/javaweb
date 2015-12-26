package com.study.threadLocal;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.study.connectionpool.JdbcUtils_C3P0;

public class AccountDao {
	
	public void update(Account account)throws SQLException{
		String sql="update account set name=?,money=? where id=?";
		
		QueryRunner qr=new QueryRunner();
		
		Object [] params={account.getName(),account.getMoney(),account.getId()};
		qr.update(ConnectionContext.getInstance().getConnection(),sql,params);
	}
	
	public Account find(int id) throws SQLException{
		QueryRunner qr=new QueryRunner();
		String sql="select id,name,money from account where id=?";
		Object [] params={id}; 
		Account account=qr.query(ConnectionContext.getInstance().getConnection(),sql,params,new BeanHandler(Account.class));
		
		return account;
	}
	
	public void insert(Account account) throws SQLException{
		QueryRunner qr=new QueryRunner();
		String sql="insert into account(name,money) values(?,?)";
		Object [] params={account.getName(),account.getMoney()};
		
		qr.update(ConnectionContext.getInstance().getConnection(), sql, params);
	}
	
	public static void main(String [] args){
		AccountDao dao=new AccountDao();
		try {
			Connection conn=JdbcUtils_C3P0.getConnection();
			ConnectionContext.getInstance().bind(conn);
			for(int i=0;i<5;i++){
				Account account=new Account();
				account.setName("Richard"+i);
				account.setMoney(1000);
				dao.insert(account);
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ConnectionContext.getInstance().remove();
		}
	}
}
