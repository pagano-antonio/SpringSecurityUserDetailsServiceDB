package com.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Customer;
import com.repository.CustomerRepository;

@RestController
@RequestMapping("customer")
public class CreateCustomer {
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private CustomerRepository customerRepository;

	//localhost:8080/customer
//	{
//		"email": "user@gmail.com",
//	    "pwd": "1234",
//	    "role": "admin"
//	}
	@PostMapping
	public void createCustomer(@RequestBody Customer customer) {

		System.out.println("customer.getPwd():" + customer.getPwd());
		customer.setPwd(passwordEncoder.encode(customer.getPwd())); // This encodes the password
		System.out.println("customer.getPwd() dopo:" + customer.getPwd());

		customerRepository.save(customer);
	}
}