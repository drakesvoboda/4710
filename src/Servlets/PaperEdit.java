package Servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.PCMember.PCMemberDao;
import Models.Paper.PaperDao;




public class PaperEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PaperDao paperDao = new PaperDao();
		PCMemberDao pcmemberDao = new PCMemberDao();
		
		String PK = request.getParameter("id"); //Get paperId from url
		
		System.out.println(PK);
		
	
		request.setAttribute("Paper", paperDao.select("SELECT * from Paper WHERE paperid = " + PK).get(0)); //Get the paper
		
		request.setAttribute("PCMembers", pcmemberDao.getAll()); //Get all the PCMembers
			
		request.getRequestDispatcher("/jsps/paper/edit.jsp").forward(request, response);
	}

}
