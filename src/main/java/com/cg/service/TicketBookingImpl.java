

package com.cg.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.TicketBooking;
import com.cg.exception.ResourceNotFoundException;
import com.cg.repository.TicketBookingRepository;
import com.cg.repository.CustomerRepository;
import com.cg.repository.MovieRepository;
import com.cg.repository.MovieShowRepository;
import com.cg.repository.TheaterMovieRepository;
import com.cg.repository.TheaterRepository;
import com.cg.entity.Customer;
import com.cg.entity.Movie;
import com.cg.entity.MovieShow;
import com.cg.entity.Theater;
import com.cg.entity.TheaterMovie;

@Service
public class TicketBookingImpl implements TicketBookingService {

	@Autowired
	private TicketBookingRepository tktBookingRepository;
	
	@Autowired
	MovieRepository movieRepository;
	
	@Autowired
	MovieShowRepository movieShowRepository;
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	TheaterRepository theaterRepository;
	
	@Autowired
	TheaterMovieRepository theaterMovieRepository;
	
	@Override
	public List<TicketBooking> getAllTicketBooking() {
		return tktBookingRepository.findAll();
	}

	@Override
	public TicketBooking getTicketBookingById(int tktBookingId) throws ResourceNotFoundException {
		
		Optional<TicketBooking> optionalTktBooking = tktBookingRepository.findById(tktBookingId);
		if (optionalTktBooking.isEmpty()) {
			throw new ResourceNotFoundException("Ticket is not existing with id: ");
		} 			
		TicketBooking ticketBooking = optionalTktBooking.get();		
		return ticketBooking;
	}
	
	@Override
	public List<TicketBooking> getAllTicketBookingForCustomer(int customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TicketBooking pushBooking(TicketBooking ticketBooking) {
		
		int theaterId = ticketBooking.getTheaterId();
		Optional<Theater> optionalTheater = theaterRepository.findById(theaterId);
		if (optionalTheater.isEmpty()) {
			throw new ResourceNotFoundException("Theater not exising with id: " + theaterId);
		}
		//Theater theater = optionalTheater.get();
		
		int movieId = ticketBooking.getMovieId();
		Optional<Movie> optionalMovie = movieRepository.findById(movieId);
		if (optionalMovie.isEmpty()) {
			throw new ResourceNotFoundException("Movie not exising with id: " + movieId);
		}
		//Movie movie = optionalMovie.get();
		
		int showId = ticketBooking.getShowId();
		Optional<MovieShow> optionalMovieShow = movieShowRepository.findById(showId);
		if (optionalMovieShow.isEmpty()) {
			throw new ResourceNotFoundException("MovieShow not exising with id: " + showId);
		}
		//MovieShow movieShow = optionalMovieShow.get();	
		
		TheaterMovie theaterMovie = theaterMovieRepository.getTheaterMovie(movieId, theaterId, showId);
		
		float totalCost = ticketBooking.getNoOfTickets()* theaterMovie.getCostPerTicket();
		
		ticketBooking.setTotalAmount(totalCost);
		ticketBooking.setStatus("Booked");
		
		return tktBookingRepository.save(ticketBooking);
	}

	@Override
	public TicketBooking updateBooking(TicketBooking ticketBooking) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteBookingById(int bookingId) {

	Optional<TicketBooking> optionaTicketBooking = tktBookingRepository.findById(bookingId);

	if(optionaTicketBooking.isEmpty()) {
	throw new ResourceNotFoundException("booking not exising with id: "+bookingId);
	}

	TicketBooking ticketbooking = optionaTicketBooking.get();

	tktBookingRepository.delete(ticketbooking);




	}
	
}