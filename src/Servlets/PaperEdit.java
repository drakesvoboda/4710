package Servlets;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.Author.AuthorDao;
import Models.PCMember.PCMemberDao;
import Models.Paper.Paper;
import Models.Paper.PaperDao;
import Models.Review.Review;
import Models.Review.ReviewDao;
import Models.Writes.WritesDao;

public class PaperEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PaperDao paperDao = new PaperDao();
		PCMemberDao pcmemberDao = new PCMemberDao();
		AuthorDao authordao = new AuthorDao();

		String PK = request.getParameter("id"); // Get paperId from url

		if (PK == null) {
			request.setAttribute("isNew", true);
			request.setAttribute("Paper", new Paper()); // Get the paper
			PK = "-1";

		} else {
			request.setAttribute("isNew", false);
			request.setAttribute(
					"Paper",
					paperDao.select("SELECT * from Paper WHERE paperid = ?", PK)
							.get(0)); // Get the paper

		}

		

		request.setAttribute("Reviewers",
				pcmemberDao.getReviewersForPaper(Integer.parseInt(PK)));

		request.setAttribute("Authors",
				authordao.getAuthorsForPaper(Integer.parseInt(PK)));

		request.setAttribute(
				"PCMembers",
				pcmemberDao
						.select("SELECT * FROM pcmember P WHERE 5 > (SELECT count(*) FROM review R WHERE R.email = P.email)")); // Get
																																// all
		request.setAttribute("AuthorsToSelect", authordao.getAll());																										// the
																																// PCMembers

		request.getRequestDispatcher("/jsps/paper/edit.jsp").forward(request,
				response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Map<String, String[]> paramMap = request.getParameterMap();

		PaperDao paperdao = new PaperDao();
		Paper paper = new Paper();

		paper.setPaperAbstract(paramMap.get("abstract")[0]);
		paper.setPdf(paramMap.get("pdf")[0]);
		paper.setTitle(paramMap.get("title")[0]);

		if (!paramMap.containsKey("PaperId")) {
			paperdao.create(paper);
		} else {
			int paperId = Integer.parseInt(paramMap.get("PaperId")[0]);
			paper.setId(paperId);

			String submit = paramMap.get("submit")[0];

			if (submit.equals("delete")) {
				paperdao.delete(paper);
			} else {
				ReviewDao reviewdao = new ReviewDao();
				WritesDao writesdao = new WritesDao();

				if (paramMap.containsKey("reviewers")) {
					String[] reviewers = paramMap.get("reviewers");

					for (String email : reviewers) {
						Review review = new Review();
						review.setEmail(email);
						review.setPaperID(paperId);
						reviewdao.create(review);
					}
				}

				paperdao.update(paper);
			}
		}

		response.sendRedirect("/Demo/Paper/List");
	}

}
