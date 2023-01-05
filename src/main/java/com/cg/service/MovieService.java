package com.cg.service;

import java.util.List;

import com.cg.entity.Movie;

public interface MovieService {

	List<Movie> getAllMovies();

	Movie updateMovie(Movie updatedMovie);

	Movie addMovie(Movie movie);

	Movie viewMovie(int movieId);

}
