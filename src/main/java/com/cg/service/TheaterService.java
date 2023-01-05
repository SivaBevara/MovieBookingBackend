package com.cg.service;

import java.util.List;

import com.cg.entity.Theater;

public interface TheaterService {
	
	List<Theater> getAllTheaters();
	public Theater addTheater(Theater theater);
	public Theater getTheaterById(int theaterId);
	Theater viewTheater(int Id);
	public Theater updateTheater(Theater updatetheater);
	public void deleteTheaterById(int theater_id);
}