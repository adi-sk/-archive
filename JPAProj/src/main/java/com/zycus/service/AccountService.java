package com.zycus.service;

import java.util.List;

import com.zycus.dao.AccountDao;
import com.zycus.entity.Account;
import com.zycus.entity.Operation;

public class AccountService {

	private AccountDao dao = new AccountDao();
	
	public void openAccount(Account account) {
		dao.add(account);
	}
	
	public void withdraw(int acno, double amount) {
		
	}

	public void deposit(int acno, double amount) {
		
	}

	public void transfer(int fromacno, int toacno, double amount) {
		withdraw(fromacno, amount);
		deposit(toacno, amount);
	}
	
	public double balance(int acno) {
		return dao.fetchBalance(acno);
	}
	
	public List<Operation> miniStatement(int acno) {
		
	}
}



