package com.zycus.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.OneToMany;

public class Order {

	private int id;
	private Date date;
	
	private Customer customer;
	
	@OneToMany(mappedBy="order")
	private Set<LineItem> lineItems;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Set<LineItem> getLineItems() {
		return lineItems;
	}

	public void setLineItems(Set<LineItem> lineItems) {
		this.lineItems = lineItems;
	}
	
	
}
