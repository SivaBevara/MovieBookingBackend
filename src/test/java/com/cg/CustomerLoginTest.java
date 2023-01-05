package com.cg;


import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cg.entity.Customer;
import com.cg.exception.CustomerNotFoundException;
import com.cg.repository.CustomerRepository;
import com.cg.service.CustomerServiceImpl;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
@SpringBootTest

class CustomerLoginTest {
	@Autowired
	private CustomerServiceImpl customerService;
	
	@MockBean
	private CustomerRepository customerRepository;
//add customer details
	@BeforeEach
	void init() {
		Customer customer=new Customer();
		
		customer.setAddress("Pune");
		customer.setCustomerName("Kruti");
		customer.setEmail("kesar@gmail.com");
		customer.setMobile("7039289372");
		customer.setPassword("jadhav");
	}
	@Test
	public void testAddCustomer() throws CustomerNotFoundException{
		ArrayList customerList=new ArrayList();
		Mockito.when(customerRepository.findAll()).thenReturn(customerList);
		assertThat(customerService.getAllCustomers()).isEqualTo(customerList);		
	}
}
