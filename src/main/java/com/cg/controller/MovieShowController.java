
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
import com.cg.entity.MovieShow;
import com.cg.service.MovieShowService;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/api/movieShow")
public class MovieShowController {

	@Autowired
	MovieShowService MovieShowService;

	@PostMapping("/add")
	public ResponseEntity<MovieShow> addMovie(@RequestBody MovieShow show_time) {
		show_time = MovieShowService.addMovieShow(show_time);
		return new ResponseEntity<>(show_time, HttpStatus.CREATED);
	}

	@PutMapping("/update")
	public ResponseEntity<MovieShow> updateMovie(@RequestBody MovieShow show_time) {
		show_time = MovieShowService.updateMovieShow(show_time);
		return new ResponseEntity<>(show_time, HttpStatus.OK);
	}

	@GetMapping("/viewMovieShow/{Id}")
	public ResponseEntity<MovieShow> viewMovie(@PathVariable int Id) {
		MovieShow show_time = MovieShowService.viewMovieShow(Id);
		return new ResponseEntity<MovieShow>(show_time, HttpStatus.OK);
	}

	@GetMapping("/getall")
	public ResponseEntity<List<MovieShow>> viewMovieList() {
		return ResponseEntity.ok(MovieShowService.getAllMovies());
	}

	@PostMapping("/deleteMovieShow/{id}")
	public ResponseEntity<String> deleteTicketBooking(@PathVariable("id") int id) {
		MovieShowService.deleteMovieShowById(id);
		return new ResponseEntity<>("Booking is Deleted", HttpStatus.OK);
	}

}