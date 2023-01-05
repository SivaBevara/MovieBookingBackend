
package com.cg.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Admin;
import com.cg.entity.Customer;
import com.cg.exception.AuthenticationFailureException;
import com.cg.model.LoggedInUser;
import com.cg.repository.AdminRepository;
import com.cg.repository.CustomerRepository;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

	@Autowired
	private AdminRepository adminRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public LoggedInUser adminLogin(String username, String password) {

		Optional<Admin> optionalAdmin = adminRepository.checkLogin(username, password);
		if (optionalAdmin.isEmpty()) {
			throw new AuthenticationFailureException("Username or Password not correct");
		}
		Admin admin = optionalAdmin.get();
		LoggedInUser loggedInUser = new LoggedInUser();
		loggedInUser.setId(admin.getId());
		loggedInUser.setName(admin.getUsername());
		loggedInUser.setRole(admin.getRole());

		return loggedInUser;
	}

	@Override
	public LoggedInUser customerLogin(String username, String password) {

		Optional<Customer> optionalCustomer = customerRepository.doCustomerLogin(username, password);
		if (optionalCustomer.isEmpty()) {
			throw new AuthenticationFailureException("Username or Password not correct");
		}
		Customer customer = optionalCustomer.get();
		LoggedInUser loggedInUser = new LoggedInUser();
		loggedInUser.setId(customer.getId());
		loggedInUser.setName(customer.getCustomerName());
		loggedInUser.setRole(customer.getRole());

		return loggedInUser;
	}

}