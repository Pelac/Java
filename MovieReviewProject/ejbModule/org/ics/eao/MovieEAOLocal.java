package org.ics.eao;

import java.util.ArrayList;
import java.util.Collection;

import javax.ejb.Local;

import org.ics.ejb.Movie;

@Local
public interface MovieEAOLocal {

	public Movie findByMovieName(String id);
	public Movie createMovie(Movie movie);
	public Movie updateMovie(Movie movie);
	public void deleteMovie(String id);
	public double getAvgRating(String movieName);
	public ArrayList<Movie> findAllMovies();
}
