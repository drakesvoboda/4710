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
		AuthorDao authorDao = new AuthorDao();
		
		request.setAttribute("Authors", authorDao.getAll()); 
					
		request.getRequestDispatcher("/jsps/author/list.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String lastname = request.getParameter("lastname");
		String lastname2 = request.getParameter("lastname2");
		
		request.setAttribute("lastname", lastname);
		request.setAttribute("lastname2", lastname2);
		
		PaperDao paperDao = new PaperDao();
		
		request.setAttribute("Papers", paperDao.getPapersRejectedBy(lastname, lastname2)); 
		
		request.setAttribute("msg", "Papers Rejected By " + lastname + " and " + lastname2); 
		
		request.getRequestDispatcher("/jsps/paper/list.jsp").forward(request, response);
		
		
	}

}
