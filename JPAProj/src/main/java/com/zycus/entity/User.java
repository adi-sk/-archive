package com.zycus.entity;

import java.util.Set;

public class User {

	private int id;
	private String username;
	private String email;
	
	private Set<Booking> bookings;
}
