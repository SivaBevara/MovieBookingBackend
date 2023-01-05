
package com.cg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Theater;
import com.cg.entity.TheaterMovie;
import com.cg.exception.ResourceNotFoundException;
import com.cg.repository.TheaterMovieRepository;

@Service
public class TheaterMovieServiceImpl implements TheaterMovieService {

	@Autowired
	private TheaterMovieRepository theaterMovieRepository;

	@Override
	public TheaterMovie fetchTheaterMovie(int movieId, int theaterId, int showId) {

		TheaterMovie theaterMovie = theaterMovieRepository.getTheaterMovie(movieId, theaterId, showId);
		return theaterMovie;
	}

	@Override
	public List<TheaterMovie> getAllTheaterMovie() {

		return theaterMovieRepository.findAll();
	}

	@Override
	public TheaterMovie addTheaterMovie(TheaterMovie theaterMovie) {

		return theaterMovieRepository.save(theaterMovie);
	}

	@Override
	public TheaterMovie viewTheaterMovie(int theaterId) {

		Optional<TheaterMovie> optionalTheaterMovie = theaterMovieRepository.findById(theaterId);
		if (optionalTheaterMovie.isEmpty()) {
			throw new ResourceNotFoundException("TheaterMovie is not existing with id: " + theaterId);
		}
		TheaterMovie theaterMovie = optionalTheaterMovie.get();
		return theaterMovie;
	}

}