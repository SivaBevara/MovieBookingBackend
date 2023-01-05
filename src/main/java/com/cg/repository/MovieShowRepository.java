package com.cg.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.entity.MovieShow;

@Repository
public interface MovieShowRepository extends JpaRepository<MovieShow, Integer> {
		
	
}