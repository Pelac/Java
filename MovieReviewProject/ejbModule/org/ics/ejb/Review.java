package org.ics.ejb;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.ics.ejb.Movie;

@Entity
@Table(name="Review")
public class Review implements Serializable {

	public Review() {}

	public Review(String movieName, int rating) {
		this.movieName = movieName;
		this.rating = rating;
	}

	private int reviewId;
	private String movieName;
	private int rating;
	private Movie movie;

	@Id
	@Column(name="ReviewId")
	public int getReviewId() {
		return reviewId;
	}
	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}
	@Column(name="MovieName")
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	@Column(name="Rating")
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}

	@ManyToOne
	@JoinColumn(name = "MovieName", insertable = false, updatable = false)// referencedColumnName = "MovieName")
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}


}
