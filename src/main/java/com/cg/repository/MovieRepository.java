package com.cg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.entity.Movie;	

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

}
