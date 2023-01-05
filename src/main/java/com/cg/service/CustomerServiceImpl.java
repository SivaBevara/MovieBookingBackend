
package com.cg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Customer;
import com.cg.exception.AuthenticationFailureException;
import com.cg.exception.CustomerNotFoundException;
import com.cg.exception.ResourceNotFoundException;
import com.cg.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Customer getCustomerById(int customerId) {
		Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
		if (optionalCustomer.isEmpty())
			throw new ResourceNotFoundException("Customer Not found with id : " + customerId);
		Customer customer = optionalCustomer.get();
		return customer;
	}

	@Override
	public List<Customer> getAllCustomers() {
		List<Customer> customers = customerRepository.findAll();
		return customers;
	}

	@Override
	public Customer addCustomer(Customer customer) {
		Customer addedCustomer = customerRepository.save(customer);
		return addedCustomer;
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		Customer updateCustomer = getCustomerById(customer.getId());
		updateCustomer = customerRepository.save(customer);
		return updateCustomer;
	}

	@Override
	public void deleteCustomerById(int customerId) {
		Customer customer = getCustomerById(customerId);
		customerRepository.delete(customer);
	}

	@Override
	public Customer checkLogin(String userName, String email, String mobile) {
		Customer customer = customerRepository.checkLogin(userName, email, mobile);
		return customer;
	}

//	@Override
//	public Admin checkLogin(String userName, String password) {
//
//		Admin admin = adminRepository.checkLogin(userName, password);
//		return admin;
//
//	}

}