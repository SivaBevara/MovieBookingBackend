

package com.cg.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "theater_movie_tbl")

public class TheaterMovie {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int movieId;
	private int theaterId;
	private int showId;
	private float costPerTicket;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public int getTheaterId() {
		return theaterId;
	}
	public void setTheaterId(int theaterId) {
		this.theaterId = theaterId;
	}
	public int getShowId() {
		return showId;
	}
	public void setShowId(int showId) {
		this.showId = showId;
	}
	public float getCostPerTicket() {
		return costPerTicket;
	}
	public void setCostPerTicket(float costPerTicket) {
		this.costPerTicket = costPerTicket;
	}	
	
}