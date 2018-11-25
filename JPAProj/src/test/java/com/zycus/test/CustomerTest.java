package com.zycus.test;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;

import com.zycus.dao.GenericDao;
import com.zycus.entity.Address;
import com.zycus.entity.Customer;

public class CustomerTest {

	@Test
	public void testAddCustomer() {
		Customer customer = new Customer();
		customer.setName("Majrul");
		customer.setEmail("majrul@gmail.com");
		customer.setCity("Mumbai");
		
		GenericDao dao = new GenericDao();
		dao.add(customer);
	}

	@Test
	public void testAddCustomerWithAddress() {
		Customer customer = new Customer();
		customer.setName("Majrul");
		customer.setEmail("majrul@gmail.com");
		//customer.setCity("Mumbai");
		Address address = new Address();
		address.setCity("Mumbai");
		address.setState("Maharashtra");
		address.setPincode(400083);
		customer.setAddress(address);
		
		GenericDao dao = new GenericDao();
		dao.add(customer);
	}

	@Test
	public void testFetchCustomerById() {
		GenericDao dao = new GenericDao();
		Customer customer = dao.fetchById(Customer.class, 1);
		assertNotNull(customer);
		System.out.println(customer); //this is wrong while writing test cases
		//rather we should use assert
	}
	
	@Test
	public void testUpdateCustomer() {
		GenericDao dao = new GenericDao();
		Customer customer = dao.fetchById(Customer.class, 1);
		customer.setCity("Pune");
		dao.update(customer);
	}

	@Test
	public void testFetchAllCustomers() {
		GenericDao dao = new GenericDao();
		List<Customer> customers = dao.fetchAll(Customer.class);
		for(Customer customer : customers)
			System.out.println(customer);		
	}

}






