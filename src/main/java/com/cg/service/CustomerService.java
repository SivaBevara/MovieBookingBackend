
package com.cg.service;

import java.util.List;
import com.cg.entity.Customer;

public interface CustomerService {

	public Customer addCustomer(Customer customer);

	public Customer getCustomerById(int customerId);

	public List<Customer> getAllCustomers();

	public Customer updateCustomer(Customer customer);

	public void deleteCustomerById(int customerId);

	Customer checkLogin(String userName, String email, String mobile);
}