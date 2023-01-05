package com.cg.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.entity.Movie;
import com.cg.exception.ResourceNotFoundException;
import com.cg.repository.MovieRepository;



@Service
public class MovieServiceImpl implements MovieService {
	@Autowired
	private MovieRepository movieRepository;
	
	@Override
	public List<Movie> getAllMovies() {

		return movieRepository.findAll();
	}

	@Override
	
	public Movie updateMovie(Movie updatedMovie) {
		return movieRepository.save(updatedMovie);
	}
	@Override
	
	public Movie addMovie(Movie movie) {
		return movieRepository.save(movie);
	}
//	@Override
//	public Movie viewMovie(int movieId) {
//		return movieRepository.getById(movieId);
//	}
	
	 @Override
	    public Movie viewMovie(int movieId) {       
	        Optional<Movie> optionalMovie = movieRepository.findById(movieId);
	        if(optionalMovie.isEmpty()) {
	            throw new ResourceNotFoundException("Movie is not existing with id: "+movieId);
	        }
	        Movie movie = optionalMovie.get();
	        return movie;
	    }

}
