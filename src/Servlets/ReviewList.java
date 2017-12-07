package Servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.ConnectionManager;


public class ReviewList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try (Connection connect = ConnectionManager.getConnection()) {
			String sql = "select R.ReviewID, P.Title, "
				+ "PC.MemberName From paper P, review R, pcmember PC Where "
				+ "P.PaperID=R.PaperID AND R.PCMemberID=PC.PCMemberID ";
			preparedStatement = connect.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();

			List<String[]> result = new ArrayList<String[]>();
			while (resultSet.next()) {
				 String toAdd[] = new String[3];
				 toAdd[0] = resultSet.getString("reviewid");
				 toAdd[1] = resultSet.getString("title");
				 toAdd[2] = resultSet.getString("membername");
				 result.add(toAdd);
			}

			request.setAttribute("Reviews", result); //Get the paper

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionManager.close(preparedStatement, resultSet);
		}

		request.getRequestDispatcher("/jsps/review/list.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
}
