package org.ics.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ics.ejb.Movie;
import org.ics.ejb.Review;
import org.ics.facade.FacadeLocal;

@WebServlet("/MovRewServlet")
public class MovRewServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private FacadeLocal facade;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MovRewServlet() {
		super();
		// TODO Auto-generated constructor stub
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		out.println("MovRewServlet-doGet");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = null;
		//Get hidden field
		String operation = request.getParameter("operation");
		
			if (operation.equals("showmovie")) {
			String movieName = request.getParameter("movieName");
			Movie m = facade.findByMovieName(movieName);
			if(m == null) {
				String searchMovieError;
				request.setAttribute("searchMovieError", "No movie found");
				url = "/findmovies.jsp";
			}
			else {
			request.setAttribute("movieName", m.getMovieName());
			request.setAttribute("genre", m.getGenre());
			request.setAttribute("releaseYear", m.getReleaseYear());
			double r = facade.getAvgRating(movieName);
			request.setAttribute("rating", r);

			url = "/findmovies.jsp";	
			}
		}
		else if (operation.equals("delmovie")) {
			String movieName = request.getParameter("movieName"); 	
			Movie m = facade.findByMovieName(movieName);
			if(m == null) {
				String delMovieError;
				request.setAttribute("delMovieError", "No movie found");
				url = "/managemovies.jsp";
			}
			else {
			for (Review r : m.getReviews()) {
				facade.deleteReview(r.getReviewId());
			}
			facade.deleteMovie(movieName);
			String feedBackDeleteMovie;
			request.setAttribute("feedBackDeleteMovie", "Movie deleted");
			url = "/managemovies.jsp";
			}
		} 
		else if (operation.equals("createReview")) {
			String movieName = request.getParameter("movieName");
			int rating = Integer.parseInt(request.getParameter("rating"));
			Movie m = facade.findByMovieName(movieName);
			if(m == null) {
				String createReviewError;
				request.setAttribute("createReviewError", "No movie found");
				url = "/managemovies.jsp";
			}else if (rating > 0) {			
			Review r = new Review(movieName, rating);
			r.setMovieName(movieName);
			r.setRating(rating);
			facade.createReview2(movieName, rating);
			String feedBackCreateReview;
			request.setAttribute("feedBackCreateReview", "Review added");
			url = "/managemovies.jsp";
			}
			else {
				String createReviewError;
				request.setAttribute("createReviewError", "Select a rating");
				url = "/managemovies.jsp";
			}
		}
		else if (operation.equals("updateMovie")) {
			String movieName = request.getParameter("movieName");
			String genre = request.getParameter("genre");
			int releaseYear = Integer.parseInt(request.getParameter("releaseYear"));
			Movie m = facade.findByMovieName(movieName);
			if(m == null) {
				String updateMovieError;
				request.setAttribute("updateMovieError", "No movie found");
				url = "/managemovies.jsp";
			}else if (genre.length() == 0) {
				String updateMovieError;
				request.setAttribute("updateMovieError", "Enter genre");
			}else if(releaseYear < 1800) {
				String updateMovieError;
				request.setAttribute("updateMovieError", "Invalid release year");
			} else {
			m.setMovieName(movieName);
			m.setGenre(genre);
			m.setReleaseYear(releaseYear);
			facade.updateMovie(m);
			String feedBackUpdateMovie;
			request.setAttribute("feedBackUpdateMovie", "Movie updated");
			url = "/managemovies.jsp";
			}
		}
		else if (operation.equals("searchmovie")) {
			url = "/findmovies.jsp";		
		} else  {
			url = "/findmovies.jsp";
		}
		System.out.println(url);
		RequestDispatcher dispatcher =
				getServletContext().getRequestDispatcher(url);
		dispatcher.forward(request, response);	
	}
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
}
