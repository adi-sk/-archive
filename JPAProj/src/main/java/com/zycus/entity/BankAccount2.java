package com.zycus.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_BANKACCOUNT2")
public class BankAccount2 extends PaymentDetails2 {

	private String bankName;
	private long accountNumber;
	
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	
}
