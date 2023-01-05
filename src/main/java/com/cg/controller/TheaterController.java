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
import com.cg.entity.Theater;
import com.cg.service.TheaterService;

	@CrossOrigin(origins="http://localhost:3000/")
	@RestController
	@RequestMapping("/api/theater")
	public class TheaterController {
		
			@Autowired
			TheaterService TheaterService;
			
			@PostMapping("/add")
			public ResponseEntity<Theater> addTheater(@RequestBody Theater theater)
			{	
					theater = TheaterService.addTheater(theater);
					return new ResponseEntity<>(theater, HttpStatus.CREATED);
			}
			
			@PutMapping("/update")
			public ResponseEntity<Theater> updateTheater(@RequestBody Theater theater)
			{
					theater = TheaterService.updateTheater(theater);
					return new ResponseEntity<>(theater, HttpStatus.OK);
			}
			
			@GetMapping("/viewTheater/{Id}")
			public ResponseEntity<Theater> viewTheater(@PathVariable int Id) 
			{
					Theater theater = TheaterService.viewTheater(Id);
					return new ResponseEntity<Theater>(theater,HttpStatus.OK);
			}

			@GetMapping("/getall")
			public ResponseEntity<List<Theater>> viewTheaterList()  
			{
					return ResponseEntity.ok(TheaterService.getAllTheaters());
			}

			@PostMapping("/deleteTheater/{id}")
			public ResponseEntity<String> deleteTheater(@PathVariable("id") int id )
			{		
				TheaterService.deleteTheaterById(id);
				return new ResponseEntity<>("Theater Details are Deleted", HttpStatus.OK);
			}
	}