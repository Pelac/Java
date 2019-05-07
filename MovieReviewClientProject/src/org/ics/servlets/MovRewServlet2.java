package org.ics.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ics.ejb.Movie;

/**
 * Servlet implementation class MovRewServlet2
 */
@WebServlet("/MovRewServlet2")
public class MovRewServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MovRewServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
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
		System.out.println("MovRewServlet2-showmovie");
		String movieName = request.getParameter("txtMovieName");
		String genre = request.getParameter("txtGenre");		
	//	Movie m = new Movie(movieName, genre);		
	//	request.setAttribute("movie", m);
		url = "/ShowMovie.jsp";
		} else if (operation.equals("searchmovie")) {
		System.out.println("MovRewServlet2-searchmovie");
		url = "/SearchMovie.jsp";
		} else {
		url ="/SearchMovie.jsp";
		}
		System.out.println(url);
		RequestDispatcher dispatcher =
		getServletContext().getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
