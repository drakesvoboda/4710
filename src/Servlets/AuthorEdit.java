package Servlets;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.Author.Author;
import Models.Author.AuthorDao;
import Models.PCMember.PCMemberDao;
import Models.PCMember.PCMember;
import Models.Paper.Paper;
import Models.Paper.PaperDao;
import Models.Review.Review;
import Models.Review.ReviewDao;
import Models.Writes.WritesDao;




public class AuthorEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AuthorDao authorDao = new AuthorDao();
		
		String PK = request.getParameter("id"); //Get pcmember email from url		
		
		if (PK == null) {
			request.setAttribute("isNew", true);
			request.setAttribute("Author", new PCMember()); // Get the paper

		} else {
			request.setAttribute("isNew", false);
			request.setAttribute("Author", authorDao.select("SELECT * from Author WHERE authorid = ?", Integer.parseInt(PK)).get(0));

		}
			
		request.getRequestDispatcher("/jsps/author/edit.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String,String[]> paramMap = request.getParameterMap();	
		
		AuthorDao authordao = new AuthorDao();		
		Author author = new Author();
		
		author.setEmail(paramMap.get("email")[0]);
		author.setAuthorName(paramMap.get("authorname")[0]);
		author.setAffiliation(paramMap.get("affiliation")[0]);
		
		if (!paramMap.containsKey("authorid")) {
			authordao.create(author);
		} else {
			author.setId(Integer.parseInt(paramMap.get("authorid")[0]));
		
			String submit = paramMap.get("submit")[0];
		
			if(submit.equals("delete")){	
				authordao.delete(author);
			}else{	
				authordao.update(author);
			}		
		}
		
		response.sendRedirect("/Demo/PCMember/List");
	}

}
