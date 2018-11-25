package com.zycus.client;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.zycus.entity.Customer;

public class ShoppingClient {

	public static void main(String[] args) {
		//add a new customer
		Customer customer = new Customer();
		customer.setName("Majrul");
		customer.setEmail("majrul@gmail.com");
		
		//For accessing REST services
		String url = "http://localhost:8080/shopping/addCustomer";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.postForEntity(url, customer, String.class);
		System.out.println(response.getBody());
	}
}
