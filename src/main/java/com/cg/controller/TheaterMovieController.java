
package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.TheaterMovie;
import com.cg.service.TheaterMovieService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/theatermovie")
public class TheaterMovieController {

	@Autowired
	private TheaterMovieService theaterMovieService;

	@PostMapping("/add")
	public ResponseEntity<TheaterMovie> addTheaterMovie(@RequestBody TheaterMovie theaterMovie) {
		TheaterMovie newTheaterMovie = theaterMovieService.addTheaterMovie(theaterMovie);
		return new ResponseEntity<>(newTheaterMovie, HttpStatus.CREATED);
	}

	@GetMapping("/view/{theaterId}")
	public ResponseEntity<TheaterMovie> viewTheaterMovie(@PathVariable int theaterId) {
		TheaterMovie theaterMovie = theaterMovieService.viewTheaterMovie(theaterId);
		return new ResponseEntity<>(theaterMovie, HttpStatus.OK);
	}

	@GetMapping("/all")
	public ResponseEntity<List<TheaterMovie>> viewTheaterMovieList() {
		return ResponseEntity.ok(theaterMovieService.getAllTheaterMovie());
	}

}