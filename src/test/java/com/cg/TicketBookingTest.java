package com.cg;

import static org.assertj.core.api.Assertions.assertThat;

import java.rmi.NotBoundException;
import java.util.ArrayList;
import java.util.Date;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.entity.TicketBooking;

import com.cg.repository.TicketBookingRepository;
import com.cg.service.TicketBookingService;

@SpringBootTest
class TicketBookingTest {

	@Autowired
	TicketBookingService ticketBookingService;
	@MockBean
	TicketBookingRepository ticketBookingRepo;
	TicketBooking a1;

	@BeforeEach
	void init() {
		a1 = new TicketBooking();
		a1.setBookingId(2);
		a1.setNoOfTickets(3);
		a1.setTotalAmount(23);
		a1.setTheaterId(67);
		a1.setShowId(001);

	}

	@Test
	void testGetAdmin() throws NotBoundException {
		ArrayList bookingList = new ArrayList();
		Mockito.when(ticketBookingRepo.findAll()).thenReturn(bookingList);
		assertThat(ticketBookingService.getAllTicketBooking()).isEqualTo(bookingList);
	}
}