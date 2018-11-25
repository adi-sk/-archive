package com.zycus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zycus.dto.OrderDetails;
import com.zycus.entity.Customer;
import com.zycus.entity.Product;
import com.zycus.service.ShoppingService;

@RestController
@RequestMapping("/shopping/*")
public class ShoppingController {

	@Autowired
	private ShoppingService shoppingService;
	
	@RequestMapping(value="/newCustomer", method=RequestMethod.POST, consumes="application/json", produces="text/plain")
	public String newCustomer(@RequestBody Customer customer) {
		shoppingService.newCustomer(customer);
		return "Customer Registered";
	}

	@RequestMapping(value="/newProduct", method=RequestMethod.POST, consumes="application/json", produces="text/plain")
	public String newProduct(@RequestBody Product product) {
		shoppingService.newProduct(product);
		return "Product Added";
	}

	@RequestMapping(value="/placeOrder", method=RequestMethod.POST, consumes="application/json", produces="text/plain")
	public String placeOrder(@RequestBody OrderDetails orderDetails) {
		shoppingService.placeOrder(orderDetails);
		return "Order Placed";
	}
	@RequestMapping(value="/customers", method=RequestMethod.GET, produces="application/json")
	public Iterable<Customer> allCustomers() {
		return shoppingService.getRegisteredCustomers();
	}	

	@RequestMapping(value="/products", method=RequestMethod.GET, produces="application/json")
	public Iterable<Product> allProducts() {
		return shoppingService.getAvailableProducts();
	}
	
	

}




