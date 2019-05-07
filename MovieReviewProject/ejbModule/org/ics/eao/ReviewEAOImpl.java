package org.ics.eao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.ics.ejb.Review;

/**
 * Session Bean implementation class ReviewEAOImpl
 */
@Stateless
public class ReviewEAOImpl implements ReviewEAOLocal {

	@PersistenceContext(unitName="LabEJBSql")
	private EntityManager em;

	public ReviewEAOImpl() {
	}  
	public Review findByReviewId(int id) {
		return em.find(Review.class, id);
	}
	public Review createReview(Review review) {
		em.persist(review);
		return review;
	}

	public Review createReview2(String movieName, int rating) {
		Query q = em.createNativeQuery("INSERT INTO Review (movieName, rating) VALUES (:movieName, :rating)");
		q.setParameter("movieName", movieName);
		q.setParameter("rating", rating);
		q.executeUpdate();
		return null;
	}

	public Review updateReview(Review review) {
		em.merge(review);
		return review;
	}

	public void deleteReview(int id) {
		Review r = this.findByReviewId(id);
		if (r != null) {
			em.remove(r);
		}
	}


}
