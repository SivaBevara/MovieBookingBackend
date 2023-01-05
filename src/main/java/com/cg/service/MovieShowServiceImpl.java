
package com.cg.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.entity.MovieShow;
import com.cg.exception.ResourceNotFoundException;
import com.cg.repository.MovieShowRepository;

@Service
public class MovieShowServiceImpl implements MovieShowService {

	@Autowired
	MovieShowRepository MovieShowRepository;

	@Override
	public List<MovieShow> getAllMovies() {
		return MovieShowRepository.findAll();
	}

	@Override
	@Transactional
	public MovieShow updateMovieShow(MovieShow show_time) {
		return MovieShowRepository.save(show_time);
	}

	@Override
	@Transactional
	public MovieShow addMovieShow(MovieShow show_time) {
		return MovieShowRepository.save(show_time);
	}

	@Override
	public MovieShow viewMovieShow(int Id) {
		Optional<MovieShow> optionalMovieShow = MovieShowRepository.findById(Id);
		if (optionalMovieShow.isEmpty()) {
			throw new ResourceNotFoundException("Movie show not existing with id: " + Id);
		}
		return optionalMovieShow.get();
	}

	@Override
	public void deleteMovieShowById(int id) {
		MovieShowRepository.deleteById(id);
	}
}
