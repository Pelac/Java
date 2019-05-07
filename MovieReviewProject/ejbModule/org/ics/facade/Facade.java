package org.ics.facade;

import java.util.ArrayList;
import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.ics.eao.MovieEAOLocal;
import org.ics.eao.ReviewEAOLocal;
import org.ics.ejb.Movie;
import org.ics.ejb.Review;

/**
 * Session Bean implementation class Facade
 */
@Stateless
public class Facade implements FacadeRemote, FacadeLocal {
	@EJB
	MovieEAOLocal movieEAO;
	@EJB
	ReviewEAOLocal reviewEAO;

	public Facade() {
	}    
	public Review findByReviewId(int id) {
		return reviewEAO.findByReviewId(id);
	}
	public Review updateReview (Review review) {
		return reviewEAO.updateReview(review);
	}
	public void deleteReview(int id) {
		reviewEAO.deleteReview(id);
	}    
	public Review createReview (Review review) {
		return reviewEAO.createReview(review);
	}
	public Review createReview2(String movieName, int rating) {
		return reviewEAO.createReview2(movieName, rating);
	}
	public Movie findByMovieName(String id) {
		return movieEAO.findByMovieName(id);
	}
	public Movie createMovie(Movie movie) {
		return movieEAO.createMovie(movie);
	}
	public Movie updateMovie(Movie movie) {
		return movieEAO.updateMovie(movie);
	}
	public void deleteMovie(String id) {
		movieEAO.deleteMovie(id);
	}
	public double getAvgRating(String movieName) {
		return movieEAO.getAvgRating(movieName);
	}
	public ArrayList<Movie> findAllMovies() {
		return movieEAO.findAllMovies();
	}
	@Override
	public Review writeReview(int reviewId, String reMovieName, int reRating, String movieName) {
		// TODO Auto-generated method stub
		return null;
	}

}
