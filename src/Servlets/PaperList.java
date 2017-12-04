package Servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.PCMember.PCMemberDao;
import Models.Paper.PaperDao;



public class PaperList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PaperDao paperDao = new PaperDao();

		
		request.setAttribute("Papers", paperDao.getAll()); //Get the paper
		
			
		request.getRequestDispatcher("/jsps/paper/list.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PaperDao paperDao = new PaperDao();
		
		String lastname = request.getParameter("lastname");
		
		request.setAttribute("lastname", lastname);
		
		request.setAttribute("Papers", paperDao.select(
				"select * from paper where paperid in (select P.paperID " +
				"from paper P, writes W, author A " +
				"where A.AuthorName=? " + 
				"	AND A.Email=W.Email " +
				"   AND W.PaperID = P.PaperID " +
				"	AND W.PaperID IN(select W.PaperID " +
				"		from Writes W " +
				"		Group By W.PaperID " +
				"		having count(W.Email)=1)) ", lastname
				)); //Get the paper
		
			
		request.getRequestDispatcher("/jsps/paper/list.jsp").forward(request, response);
	}

}
