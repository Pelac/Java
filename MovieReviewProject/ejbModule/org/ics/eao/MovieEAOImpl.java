package org.ics.eao;

import java.util.ArrayList;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.ics.ejb.Movie;

/**
 * Session Bean implementation class MovieEAOImpl
 */
@Stateless
public class MovieEAOImpl implements MovieEAOLocal {

	@PersistenceContext(unitName="LabEJBSql")
	private EntityManager em;

	public MovieEAOImpl() {
	}	
	public Movie findByMovieName(String id) {
		return em.find(Movie.class, id);
	}

	public Movie createMovie(Movie movie) {
		em.persist(movie);
		return movie;
	}

	public Movie updateMovie(Movie movie) {
		em.merge(movie);
		return movie;
	}

	public void deleteMovie(String id) {
		Movie m = this.findByMovieName(id);
		if (m != null) {
			em.remove(m);
		}
	}
	public double getAvgRating(String movieName) {
		Query q = em.createQuery("SELECT AVG(Review.rating) AS average FROM Movie Movie JOIN Review Review ON Movie.movieName = Review.movieName WHERE Movie.movieName =:movieName");
		q.setParameter("movieName", movieName);
		double avg = ((Number)q.getSingleResult()).doubleValue();
		return avg;
	}
	public ArrayList<Movie> findAllMovies() {
		Query query = em.createQuery("SELECT Movie FROM Movie Movie");
		return (ArrayList<Movie>) query.getResultList();
	}

}
