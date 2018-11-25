package com.zycus.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_CREDITCARD2")
public class CreditCard2 extends PaymentDetails2 {

	private long cardNumber;
	private String expiryDate;
	private int cvv;
	public long getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(long cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
	public int getCvv() {
		return cvv;
	}
	public void setCvv(int cvv) {
		this.cvv = cvv;
	}
	
	
}
