package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Movie;

import com.cg.service.MovieService;


@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/api/movie")
public class MovieController {
	
	@Autowired
	MovieService movieService;

	@PostMapping("/add")
	public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) {
		movie = movieService.addMovie(movie);
		return new ResponseEntity<>(movie, HttpStatus.CREATED);
	}

	@PutMapping("/update")
	public ResponseEntity<Movie> updateMovie(@RequestBody Movie movie) {
		movie = movieService.updateMovie(movie);
		return new ResponseEntity<>(movie, HttpStatus.OK);
	}

	@GetMapping("/viewMovie/{movieId}")
	public ResponseEntity<Movie> viewMovie(@PathVariable int movieId)  {

		Movie movie = movieService.viewMovie(movieId);
		
		return new ResponseEntity<>(movie, HttpStatus.OK);
	}

	@GetMapping("/findall")
	public ResponseEntity<List<Movie>> viewMovieList() {

		return ResponseEntity.ok(movieService.getAllMovies());
	}
	
}
