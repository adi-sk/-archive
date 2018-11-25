package com.zycus.test;

import org.junit.Test;

import com.zycus.dao.GenericDao;
import com.zycus.entity.BankAccount;
import com.zycus.entity.CreditCard;

public class PaymentDetailsTest {

	@Test
	public void add() {
		GenericDao dao = new GenericDao();
		BankAccount bankAcc = new BankAccount();
		bankAcc.setAccountNumber(1111);
		bankAcc.setBankName("ICICI");
		bankAcc.setNameOfThePerson("Majrul");
		bankAcc.setAmount(5000);
		dao.add(bankAcc);
		
		CreditCard card = new CreditCard();
		card.setNameOfThePerson("Majrul");
		card.setCardNumber(12345);
		card.setExpiryDate("12/2020");
		card.setCvv(123);
		card.setAmount(5000);
		dao.add(card);
		
	}
}
