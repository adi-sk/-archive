package com.zycus.component;

public class HdfcAtm implements Atm {

	private Bank bank;
	
	public void setBank(Bank bank) {
		this.bank = bank;
	}
	
	public void withdraw(int acno, double amount, String atmId) {
		System.out.println("withdraw..");
		bank.communicate(null);
	}
}
