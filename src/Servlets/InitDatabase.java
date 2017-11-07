package Servlets;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.ConnectionManager;

/**
 * Servlet implementation class UserServlet
 */

public class InitDatabase extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InitDatabase() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Scanner scanner = null;
		Statement statement = null;
	    try{
	    	scanner = new Scanner("/Sql/inti.sql").useDelimiter(";");
	    	try(Connection connect = ConnectionManager.getConnection())
			{		
				while(scanner.hasNext()){			
					String sqlStatement = scanner.next() + ";";
					try{
						statement = connect.createStatement();
						statement.execute(sqlStatement);
					}finally{
						 if (statement != null) {
							 statement.close();
						 }
						statement = null;
					}
				}    
			   
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	    	
	    }finally{
	    	scanner.close();
	    };		
		
	}

}