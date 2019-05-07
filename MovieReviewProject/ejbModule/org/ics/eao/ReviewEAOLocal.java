package org.ics.eao;

import javax.ejb.Local;

import org.ics.ejb.Review;

@Local
public interface ReviewEAOLocal {

	public Review findByReviewId(int id);
	public Review createReview(Review review);
	public Review createReview2(String movieName, int rating);
	public Review updateReview(Review review);
	public void deleteReview(int id);
}
