
package com.cg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.entity.TheaterMovie;

public interface TheaterMovieRepository extends JpaRepository<TheaterMovie, Integer> {

	@Query("Select tm from TheaterMovie tm where tm.movieId = :mId and tm.theaterId = :tId and tm.showId= :sId")
	TheaterMovie getTheaterMovie(@Param("mId") int movieId, @Param("tId") int theaterId, @Param("sId") int showId);
}