
package com.cg.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Customer;
import com.cg.exception.AccessForbiddenException;
import com.cg.exception.AdminNotFoundException;
import com.cg.exception.CustomerNotFoundException;
import com.cg.model.LoginReq;
import com.cg.service.CustomerService;

@RestController // add controller annotation coz we need to make spring to handle request
@RequestMapping("/api/customer")
@CrossOrigin(origins = "http://localhost:3000/")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	// @RequestMapping(value = "/customers",method = RequestMethod.GET)
	@GetMapping("/all")
	public List<Customer> getAllCustomers() {
		return customerService.getAllCustomers();
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<?> getCustomerById(@PathVariable("id") int customerId) {

		ResponseEntity<Object> responseEntity = null;
		Customer customer = customerService.getCustomerById(customerId);
		responseEntity = new ResponseEntity<>(customer, HttpStatus.OK);
		return responseEntity;
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteCustomerById(@PathVariable("id") int customerId) {

		ResponseEntity<Object> responseEntity = null;
		customerService.deleteCustomerById(customerId);
		responseEntity = new ResponseEntity<>("Customer data deleted successfully", HttpStatus.OK);
		return responseEntity;
	}

//	@PostMapping("/save")
//	public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer) {
//
//		ResponseEntity<Customer> responseEntity = null;
//		Customer saveCustomer = customerService.saveCustomer(customer);
//		responseEntity = new ResponseEntity<>(saveCustomer, HttpStatus.CREATED);
//		return responseEntity;
//	}

	@PutMapping("/update")
	public ResponseEntity<?> updateCustomer(@RequestBody Customer customer) {

		ResponseEntity<Object> responseEntity = null;
		Customer updateCustomer = customerService.updateCustomer(customer);
		responseEntity = new ResponseEntity<>(updateCustomer, HttpStatus.OK);
		return responseEntity;
	}

	@PostMapping("/add")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) throws CustomerNotFoundException {

		Customer existingUser = customerService.checkLogin(customer.getUsername(), customer.getEmail(),
				customer.getMobile());
		if (existingUser != null) {
			throw new CustomerNotFoundException("Failed to add new Customer");

		}
		Customer a = customerService.addCustomer(customer);
		if (a == null) {
			throw new CustomerNotFoundException("Failed to add new Customer");
		}
		return new ResponseEntity<Customer>(a, HttpStatus.OK);
	}

}