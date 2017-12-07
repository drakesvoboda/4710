package Servlets;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.PCMember.PCMemberDao;
import Models.PCMember.PCMember;




public class PCMemberEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PCMemberDao pcmemberDao = new PCMemberDao();
		
		String PK = request.getParameter("id"); //Get pcmember email from url		
		
		if (PK == null) {
			request.setAttribute("isNew", true);
			request.setAttribute("PCMember", new PCMember()); // Get the paper

		} else {
			request.setAttribute("isNew", false);
			request.setAttribute("PCMember", pcmemberDao.select("SELECT * from PCMember WHERE pcmemberid = ?", Integer.parseInt(PK)).get(0));

		}
			
		request.getRequestDispatcher("/jsps/PCMember/edit.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Map<String,String[]> paramMap = request.getParameterMap();	
		
		PCMemberDao pcmemberdao = new PCMemberDao();		
		PCMember pcmember = new PCMember();
		
		pcmember.setEmail(paramMap.get("email")[0]);
		pcmember.setMemberName(paramMap.get("membername")[0]);
		
		if (!paramMap.containsKey("PCmemberID")) {
			pcmemberdao.create(pcmember);
		} else {
			pcmember.setId(Integer.parseInt(paramMap.get("PCmemberID")[0]));
		
			String submit = paramMap.get("submit")[0];
		
			if(submit.equals("delete")){	
				pcmemberdao.delete(pcmember);
			}else{	
				pcmemberdao.update(pcmember);
			}		
		}
		
		response.sendRedirect("/Demo/PCMember/List");
	}

}
