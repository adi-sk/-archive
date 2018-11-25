package com.zycus.entity;

import java.util.Date;
import java.util.Set;

public class Booking {

	private int pnr;
	private Date bookingDate;
	
	private Train train;
	private User user;
	
	private Set<Passenger> passengers;
	
}
