package com.zycus.entity;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_BANKACCOUNT3")
@PrimaryKeyJoinColumn(name = "payment_id", referencedColumnName = "id")
public class BankAccount3 extends PaymentDetails3 {

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
