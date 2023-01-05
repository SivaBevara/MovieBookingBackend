
package com.cg.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Customer;
import com.cg.entity.TicketBooking;
import com.cg.model.TicketBookingReq;
import com.cg.service.CustomerService;
import com.cg.service.MovieService;
import com.cg.service.MovieShowService;
import com.cg.service.TheaterService;
import com.cg.service.TicketBookingService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/booking")
public class BookingController {

	@Autowired
	private TicketBookingService ticketBookingService;

	@Autowired
	private CustomerService customerService;

	@PostMapping("/add")
	public ResponseEntity<TicketBooking> addTicketBooking(@RequestBody TicketBookingReq bookingReq) {

		Customer customer = customerService.getCustomerById(bookingReq.getCustomerId());

		TicketBooking tktBooking = new TicketBooking();
		tktBooking.setShowDate(bookingReq.getShowDate());
		tktBooking.setBookingDateTime(LocalDateTime.now());
		tktBooking.setNoOfTickets(bookingReq.getNoOfTickets());
		tktBooking.setTheaterId(bookingReq.getTheaterId());
		tktBooking.setMovieId(bookingReq.getMovieId());
		tktBooking.setShowId(bookingReq.getShowId());
		tktBooking.setCustomer(customer);

		TicketBooking b1 = ticketBookingService.pushBooking(tktBooking);
		return new ResponseEntity<TicketBooking>(b1, HttpStatus.OK);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Object> getBookingByID(@PathVariable("id") int ID) {
		TicketBooking b = ticketBookingService.getTicketBookingById(ID);
		if (b == null) {
			return new ResponseEntity<>("sorry booking id not found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(b, HttpStatus.OK);
	}

	@GetMapping("/all")
	public ResponseEntity<List<TicketBooking>> getAllBooking() {
		List<TicketBooking> list = ticketBookingService.getAllTicketBooking();
		System.out.println(list);
		return new ResponseEntity<List<TicketBooking>>(list, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteTicketBooking(@PathVariable("id") int id) {
		ticketBookingService.deleteBookingById(id);
		return new ResponseEntity<>("Booking is Deleted", HttpStatus.OK);
	}

}