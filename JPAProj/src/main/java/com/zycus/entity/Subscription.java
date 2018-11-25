package com.zycus.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Subscription {

	@Id
	@GeneratedValue
	private int id;
	
	private String subscriptionFor;
	private double monthlyFees;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSubscriptionFor() {
		return subscriptionFor;
	}
	public void setSubscriptionFor(String subscriptionFor) {
		this.subscriptionFor = subscriptionFor;
	}
	public double getMonthlyFees() {
		return monthlyFees;
	}
	public void setMonthlyFees(double monthlyFees) {
		this.monthlyFees = monthlyFees;
	}
	
	
}
