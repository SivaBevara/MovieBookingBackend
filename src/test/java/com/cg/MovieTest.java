package com.cg;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.entity.Movie;

import com.cg.exception.ResourceNotFoundException;
import com.cg.repository.MovieRepository;
import com.cg.service.MovieService;
@SpringBootTest
public class MovieTest {
	@Autowired
	MovieService movieService;
	@MockBean
	MovieRepository movieRepo;
	Movie a1;
	@BeforeEach
	void init() {
		a1 = new Movie();
		a1.setMovieId(001);
		a1.setTitle("RRR");
		a1.setDuration(3);
		a1.setGenre("action");

	}
	@Test
	void testAddMovie() {
		
		Mockito.when(movieRepo.save(a1)).thenReturn(a1);
		assertThat(movieService.addMovie(a1).equals(a1));

	}
	@Test
	void testGetAdmin() throws ResourceNotFoundException {
		ArrayList movieList = new ArrayList();


		Mockito.when(movieRepo.findAll()).thenReturn(movieList);
		assertThat(movieService.getAllMovies()).isEqualTo(movieList);
	}
}

