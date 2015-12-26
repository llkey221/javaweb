package com.study.threadLocal.biz;

import java.sql.SQLException;

import com.study.threadLocal.Account;
import com.study.threadLocal.AccountDao;

public class AccountService {
	
	public void transfer(int sourceid,int targetid,float money) throws SQLException{
		AccountDao dao=new AccountDao();
		Account source=dao.find(sourceid);
		Account target=dao.find(targetid);
		source.setMoney(source.getMoney()-money);
		target.setMoney(target.getMoney()+money);
		dao.update(source);
//		int x=1/0;
		dao.update(target);		
	}
	
}
