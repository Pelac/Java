package org.ics.facade;

import java.util.ArrayList;

import javax.ejb.Remote;

import org.ics.ejb.Movie;
import org.ics.ejb.Review;

@Remote
public interface FacadeRemote {

	public Movie findByMovieName(String id);
	public Movie createMovie(Movie movie);
	public Movie updateMovie(Movie movie);
	public void deleteMovie(String id);
	public double getAvgRating(String movieName);
	public ArrayList<Movie> findAllMovies();
	
	public Review findByReviewId(int id);
	//public Review createReview(Review review);
	public Review writeReview(int reviewId, String reMovieName, int reRating, String movieName);
	public Review updateReview(Review review);
	public void deleteReview(int id);

}
