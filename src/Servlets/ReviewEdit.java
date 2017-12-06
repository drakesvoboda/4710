package Servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.ConnectionManager;
import Models.Author.AuthorDao;
import Models.PCMember.PCMemberDao;
import Models.PCMember.PCMember;
import Models.Paper.Paper;
import Models.Paper.PaperDao;
import Models.Review.Review;
import Models.Review.ReviewDao;
import Models.Writes.WritesDao;




public class ReviewEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ReviewDao reviewDao = new ReviewDao();
		String PK = request.getParameter("reviewID"); //Get pcmember email from url		
		
		System.out.print(PK);
	
		if (PK == null) {
			request.setAttribute("isNew", true);
			request.setAttribute("Review", new Review()); // Get the paper
			PK = "-1";

		} else {
			request.setAttribute("isNew", false);
			request.setAttribute(
					"Review",
					reviewDao.select("SELECT * from Review WHERE reviewID = ?", PK)
							.get(0)); // Get the paper

		}

					
		request.getRequestDispatcher("/jsps/review/edit.jsp").forward(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpSerDvletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Map<String,String[]> paramMap = request.getParameterMap();	
		
		PCMemberDao pcmemberdao = new PCMemberDao();		
		PCMember pcmember = new PCMember();
			
		pcmember.setEmail(paramMap.get("email")[0]);
		pcmember.setMemberName(paramMap.get("membername")[0]);
		pcmember.setId(Integer.parseInt(paramMap.get("id")[0]));
		
		String submit = paramMap.get("submit")[0];
		
		if(submit.equals("delete")){	
			pcmemberdao.delete(pcmember);
		}else{	
			pcmemberdao.update(pcmember);
		}		
		
		response.sendRedirect("/Demo/Review/List");
	}

}
