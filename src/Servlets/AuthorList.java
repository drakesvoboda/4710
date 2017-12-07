 package Servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.Author.AuthorDao;
import Models.PCMember.PCMemberDao;
import Models.Paper.PaperDao;


public class AuthorList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AuthorDao authorDao = new AuthorDao();
		
		request.setAttribute("Authors", authorDao.getAll()); 
					
		request.getRequestDispatcher("/jsps/author/list.jsp").forward(request, response);
	}	
		
		
}