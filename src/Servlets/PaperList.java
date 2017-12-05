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

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PaperDao paperDao = new PaperDao();

		request.setAttribute("Papers", paperDao.getAll()); // Get the paper
		

		request.setAttribute("recommended_papers",
				paperDao.getRecommendedPapers());

		request.getRequestDispatcher("/jsps/paper/list.jsp").forward(request,
				response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		PaperDao paperDao = new PaperDao();

		String lastname = request.getParameter("lastname");
		String lastname2 = request.getParameter("lastname2");

		request.setAttribute("lastname", lastname);
		request.setAttribute("lastname2", lastname2);

		String type = request.getParameter("type");

		request.setAttribute("type", type);

		switch (type) {

		case "twoauthors":
			request.setAttribute(
					"Papers",
					paperDao.getPapersByTwoAuthors(lastname, lastname2));
			break;
		case "singleauthor":
			request.setAttribute("Papers", paperDao.getPapersBySingleAuthor(lastname));
			break;
		case "firstauthor":
			request.setAttribute(
					"Papers",
					paperDao.getPapersByFirstAuthor(lastname));
			break;

		}

		request.setAttribute("recommended_papers",
				paperDao.getRecommendedPapers());

		request.getRequestDispatcher("/jsps/paper/list.jsp").forward(request,
				response);
	}
}
