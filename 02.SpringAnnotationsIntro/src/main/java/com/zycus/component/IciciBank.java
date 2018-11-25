package com.zycus.component;

import org.springframework.stereotype.Component;

@Component
public class IciciBank implements Bank {

	public void communicate(byte[] data) {
		System.out.println("communication successful..");
	}

	
}
