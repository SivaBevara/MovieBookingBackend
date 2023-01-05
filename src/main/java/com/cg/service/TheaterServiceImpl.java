package com.cg.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.repository.TheaterRepository;
import com.cg.entity.Theater;
import com.cg.exception.ResourceNotFoundException;

@Service
public class TheaterServiceImpl implements TheaterService {

		@Autowired
		TheaterRepository theaterRepository;

		@Override
		@Transactional
		public Theater addTheater(Theater theater) {
			return theaterRepository.save(theater);
		}

		@Override
		public Theater getTheaterById(int theaterId) {
			return theaterRepository.getById(theaterId);
		}

		@Override
		@Transactional
		public Theater updateTheater(Theater theater) {
			return theaterRepository.save(theater);
		}

		@Override
		public void deleteTheaterById(int theater_id) {
			theaterRepository.deleteById(theater_id);
		}

		@Override
		public Theater viewTheater(int Id) {
			 Optional<Theater> optionalTheater = theaterRepository.findById(Id);
		        if(optionalTheater.isEmpty()) {
		            throw new ResourceNotFoundException("Movie show not existing with id: "+Id);
		        }
		        return optionalTheater.get();

			
		}

		@Override
		public List<Theater> getAllTheaters() {
			return theaterRepository.findAll();
		}
}