package Servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.Review.ReviewDao;


public class ReviewList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ReviewDao reviewDao = new ReviewDao();

		
		request.setAttribute("Reviews", reviewDao.getAll()); //Get the paper
		
			
		request.getRequestDispatcher("/jsps/review/list.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ReviewDao reviewDao = new ReviewDao();
		
		request.setAttribute("Reviews", reviewDao.getAll()); //Get the paper

					
		request.getRequestDispatcher("/jsps/review/list.jsp").forward(request, response);
	}

}
