package Servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.tribes.util.Arrays;

import user.domain.User;
import Models.PCMember.PCMemberDao;
import Models.Paper.PaperDao;
import Models.Review.Review;
import Models.Review.ReviewDao;


public class PaperUpdate extends HttpServlet {
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
		Map<String,String[]> paramMap = request.getParameterMap();
		
		ReviewDao reviewdao = new ReviewDao();
		
		String[] reviewers = paramMap.get("reviewers");
		int paperId = Integer.parseInt(paramMap.get("PaperId")[0]);
		
		for(String email : reviewers){
			Review review = new Review();
			review.setEmail(email);
			review.setPaperID(paperId);
			reviewdao.create(review);
		}
		
	}

}
