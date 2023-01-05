package com.cg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cg.entity.Theater;

public interface TheaterRepository extends JpaRepository<Theater,Integer> {

}