package com.zycus.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class HdfcAtm implements Atm {

	private Bank bank;
	
	@Autowired
	//@Qualifier("iciciBank")
	public void setBank(Bank bank) {
		this.bank = bank;
	}
	
	public void withdraw(int acno, double amount, String atmId) {
		System.out.println("withdraw..");
		bank.communicate(null);
	}
}
