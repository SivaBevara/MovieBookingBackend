
package com.cg.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "customer_tbl")
public class Customer extends User {

	@Column(name = "customer_name")
	private String customerName;

	@Column(name = "email")
	private String email;

	@Column(name = "mobile")
	private String mobile;

	@Column(name = "address")
	private String address;
	@JsonIgnore
	@OneToMany(mappedBy = "customer")
//	@JsonBackReference
	// @JsonIgnoreProperties("customer")
	private List<TicketBooking> bookings = new ArrayList<>();

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<TicketBooking> getBookings() {
		return bookings;
	}

	public void setBookings(List<TicketBooking> bookings) {
		this.bookings = bookings;
	}

}