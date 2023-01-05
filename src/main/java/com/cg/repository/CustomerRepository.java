
package com.cg.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	@Query("Select c from Customer c where c.username = :uname and c.password = :upwd")
	Optional<Customer> doCustomerLogin(@Param("uname") String username, @Param("upwd") String password);

	@Query("Select a from Customer a where a.username=?1  or a.email=?2 or a.mobile=?3")
	Customer checkLogin(String username, String email, String mobile);

}