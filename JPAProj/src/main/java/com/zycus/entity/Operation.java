package com.zycus.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Operation {

	@Id
	@GeneratedValue
	private int txno;
	
	private Date txDate;
	private double amount;
	private String txType;
	
	@ManyToOne
	@JoinColumn(name = "acno")
	private Account account;

	public int getTxno() {
		return txno;
	}

	public void setTxno(int txno) {
		this.txno = txno;
	}

	public Date getTxDate() {
		return txDate;
	}

	public void setTxDate(Date txDate) {
		this.txDate = txDate;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getTxType() {
		return txType;
	}

	public void setTxType(String txType) {
		this.txType = txType;
	}

	public Account getOperation() {
		return account;
	}

	public void setOperation(Account account) {
		this.account = account;
	}
	
	
	
}
