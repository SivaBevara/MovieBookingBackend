
package com.cg.service;

import java.util.List;

import com.cg.entity.TheaterMovie;

public interface TheaterMovieService {

	TheaterMovie fetchTheaterMovie(int movieId, int theaterId, int showId);

	List<TheaterMovie> getAllTheaterMovie();

	TheaterMovie addTheaterMovie(TheaterMovie theaterMovie);

	TheaterMovie viewTheaterMovie(int theaterId);

//	Theater updateTheater(Theater theater);

//	void deleteTheater(int theaterId);
}