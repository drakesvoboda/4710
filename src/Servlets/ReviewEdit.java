package Servlets;

import java.io.IOException;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.PCMember.PCMemberDao;
import Models.Review.Review;
import Models.Review.ReviewDao;




public class ReviewEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ReviewDao reviewDao = new ReviewDao();
		String PK = request.getParameter("reviewID"); //Get pcmember email from url		
			
		if (PK == null) {
			request.setAttribute("isNew", true);
			request.setAttribute("Review", new Review()); // Get the paper
			PK = "-1";

		} else {
			request.setAttribute("isNew", false);
			Review review = reviewDao.select("SELECT * from Review WHERE reviewID = ?", Integer.parseInt(PK)).get(0);
			request.setAttribute(
					"Review",
					review
							); // Get the paper
			
			PCMemberDao pcmemberDao = new PCMemberDao();
			request.setAttribute("ReplacementsForDelete", pcmemberDao.getPCMemberElegableForReviewWhoIsNotAlreadyReviewingPaper(review.PaperID));
		}		
		
		request.getRequestDispatcher("/jsps/review/edit.jsp").forward(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpSerDvletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Map<String,String[]> paramMap = request.getParameterMap();	
		
		ReviewDao reviewdao = new ReviewDao();		
		Review review = new Review();
			
		review.setId(Integer.parseInt(paramMap.get("reviewid")[0]));
		review.setPaperID(Integer.parseInt(paramMap.get("paperid")[0]));
		review.setPCMemberId(Integer.parseInt(paramMap.get("pcmemberid")[0]));
		review.setComment(paramMap.get("comments")[0]);
		
 		review.setRecommend(paramMap.containsKey("recommend"));
		review.setSubDate(new Date());
		
		String submit = paramMap.get("submit")[0];
		
		if(submit.equals("delete")){
			String replacementPCMember = paramMap.get("replacementPCMember")[0];
			Review replacement = new Review();
			replacement.setPaperID(review.getPaperID());
			replacement.setPCMemberId(Integer.parseInt(replacementPCMember));		
			reviewdao.delete(review);
			reviewdao.create(replacement);
		}else{	
			reviewdao.update(review);
		}		
		
		response.sendRedirect("/Demo/Review/List");
	}
}
