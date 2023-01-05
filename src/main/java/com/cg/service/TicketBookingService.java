

package com.cg.service;

import java.util.List;

import com.cg.entity.TicketBooking;
import com.cg.exception.ResourceNotFoundException;

public interface TicketBookingService {

	List<TicketBooking> getAllTicketBooking();
	
	List<TicketBooking> getAllTicketBookingForCustomer(int customerId);

	TicketBooking getTicketBookingById(int bookingId) throws ResourceNotFoundException;

	TicketBooking pushBooking(TicketBooking ticketBooking);

	TicketBooking updateBooking(TicketBooking ticketBooking) throws ResourceNotFoundException;

	void deleteBookingById(int bookingId);
	
	
}