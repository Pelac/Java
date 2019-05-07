package org.ics.ejb;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.ics.ejb.Review;

@Entity
@Table(name="Movies")
public class Movie implements Serializable {

	private String movieName;
	private int releaseYear;
	private String genre;
	private Set<Review>reviews;

	@Id
	@Column(name="MovieName")
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	@Column(name="ReleaseYear")
	public int getReleaseYear() {
		return releaseYear;
	}
	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}
	@Column(name="Genre")
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}

	@OneToMany(mappedBy = "movie", fetch = FetchType.EAGER)
	public Set<Review> getReviews() {
		return reviews;
	}
	public void setReviews(Set<Review>reviews) {
		this.reviews = reviews;
	}

}
