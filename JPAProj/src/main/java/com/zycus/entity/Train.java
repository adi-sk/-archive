package com.zycus.entity;

import java.util.Set;

public class Train {

	private int trainNo;
	private String name;
	private String source;
	private String destination;
	
	private Set<Booking> bookings;
}
