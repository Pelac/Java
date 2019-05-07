package org.ics.facade;

import java.util.ArrayList;
import java.util.Collection;

import javax.ejb.Local;

import org.ics.ejb.Movie;
import org.ics.ejb.Review;

@Local
public interface FacadeLocal {

	public Movie findByMovieName(String id);
	public Movie createMovie(Movie movie);
	public Movie updateMovie(Movie movie);
	public void deleteMovie(String id);
	public double getAvgRating(String movieName);
	public ArrayList<Movie> findAllMovies();

	public Review findByReviewId(int id);
	public Review createReview2(String movieName, int rating);
	public Review createReview(Review review);
	public Review updateReview(Review review);
	public void deleteReview(int id);


}
