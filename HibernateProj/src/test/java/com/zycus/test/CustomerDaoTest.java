package com.zycus.test;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;

import com.zycus.dao.CustomerDao;
import com.zycus.entity.Customer;

public class CustomerDaoTest {

	@Test
	public void testAddCustomer() {
		Customer customer = new Customer();
		customer.setName("Majrul");
		customer.setEmail("majrul@gmail.com");
		customer.setCity("Mumbai");
		
		CustomerDao dao = new CustomerDao();
		dao.add(customer);
	}
	
	@Test
	public void testFetchCustomerById() {
		CustomerDao dao = new CustomerDao();
		Customer customer = dao.fetchById(1);
		assertNotNull(customer);
		System.out.println(customer); //this is wrong while writing test cases
		//rather we should use assert
	}
	
	@Test
	public void testUpdateCustomer() {
		CustomerDao dao = new CustomerDao();
		Customer customer = dao.fetchById(1);
		customer.setCity("Pune");
		dao.update(customer);
	}

	@Test
	public void testFetchAllCustomers() {
		CustomerDao dao = new CustomerDao();
		List<Customer> customers = dao.fetchAll();
		for(Customer customer : customers)
			System.out.println(customer);		
	}

}






