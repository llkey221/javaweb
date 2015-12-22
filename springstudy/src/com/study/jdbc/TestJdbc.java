package com.study.jdbc;

import java.util.Scanner;

public class TestJdbc {
	
	public static void main(String[] args) {
		
//		JdbcCRUDStatement.Insert();
//		
//		JdbcCRUDStatement.Query();
//		
//		JdbcCRUDStatement.Update();
//		
//		JdbcCRUDStatement.Query();
//		
//		JdbcCRUDStatement.Delete();
		
//		JdbcCURDByPreparedStatement.Insert();
//		
//		JdbcCURDByPreparedStatement.Query();
	/*	JdbcCURDByPreparedStatement.BatchSql();
		
		JdbcCRUDStatement.BatchSql();*/
		JdbcTransaction trans=new JdbcTransaction();
		trans.SavaRollbackPoint();
		trans.TransferAccount();
		
	}
}
