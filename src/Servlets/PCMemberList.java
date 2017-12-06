 package Servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.PCMember.PCMemberDao;


public class PCMemberList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PCMemberDao pcmemberDao = new PCMemberDao();
		
		request.setAttribute("PCMembers", pcmemberDao.getAll()); //Get the paper

		request.setAttribute("PCMembersNoReview", pcmemberDao.getPCMembersWithNoReviews()); //Get the paper
		request.setAttribute("PCMembersMostReview", pcmemberDao.getPCMembersWithMostReviews()); //Get the paper
					
		request.getRequestDispatcher("/jsps/PCMember/list.jsp").forward(request, response);
	}

}
