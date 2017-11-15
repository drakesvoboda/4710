package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.ConnectionManager;
import Models.Paper.Paper;
import Models.Paper.PaperDao;
import MySqlAnnotations.ColumnName;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Statement statement = null;

		String[] scanner = new String(
				"DROP TABLE IF EXISTS Review, PCMember, Writes, Paper, Author;"
						+ "CREATE TABLE Paper	(                                          "
						+ "	PaperID 	INTEGER AUTO_INCREMENT,                            "
						+ "	Title 		VARCHAR(50),                                       "
						+ "	Abstract 	VARCHAR(250),                                      "
						+ "	Pdf 		VARCHAR(100),                                      "
						+ "	PRIMARY KEY (PaperID)                                          "
						+ ");															   "

						+ "INSERT INTO Paper (Title, Abstract, Pdf)						   "
						+ "VALUES ('Sample 1', 'Lorem Ipsum Dolor', 'Sample PDF');	       " 
						
						+ "INSERT INTO Paper (Title, Abstract, Pdf)						   "
						+ "VALUES ('Sample 2', 'Lorem Ipsum Dolor', 'Sample PDF');    	   "
						
						+ "INSERT INTO Paper (Title, Abstract, Pdf)						   "
						+ "VALUES ('Sample 3', 'Lorem Ipsum Dolor', 'Sample PDF');    	   "
						
						+ "INSERT INTO Paper (Title, Abstract, Pdf)						   "
						+ "VALUES ('Sample 4', 'Lorem Ipsum Dolor', 'Sample PDF');    	   "
						
						+ "INSERT INTO Paper (Title, Abstract, Pdf)						   "
						+ "VALUES ('Sample 5', 'Lorem Ipsum Dolor', 'Sample PDF');	       "
						
						+ "INSERT INTO Paper (Title, Abstract, Pdf)						   "
						+ "VALUES ('Sample 6', 'Lorem Ipsum Dolor', 'Sample PDF');    	   "
						
						+ "INSERT INTO Paper (Title, Abstract, Pdf)						   "
						+ "VALUES ('Sample 7', 'Lorem Ipsum Dolor', 'Sample PDF');    	   "
						
						+ "INSERT INTO Paper (Title, Abstract, Pdf)						   "
						+ "VALUES ('Sample 8', 'Lorem Ipsum Dolor', 'Sample PDF');    	   "
						
						+ "INSERT INTO Paper (Title, Abstract, Pdf)						   "
						+ "VALUES ('Sample 9', 'Lorem Ipsum Dolor', 'Sample PDF');    	   "
						
						+ "INSERT INTO Paper (Title, Abstract, Pdf)						   "
						+ "VALUES ('Sample 10', 'Lorem Ipsum Dolor', 'Sample PDF');    	   "
												
						+"CREATE TABLE Author	(                                          "
						+ "	Email 		VARCHAR(100),                                      "
						+ "	AuthorName 	VARCHAR(50),                                       "
						+ "	Affiliation VARCHAR(100),                                      "
						+ "	PRIMARY KEY (email)                                            "
						+ ");                                                              "

						+ "INSERT INTO Author (Email, AuthorName, Affiliation)						   "
						+ "VALUES ('drake@author.com', 'Drake', 'ASU');    	   "
						
						+ "INSERT INTO Author (Email, AuthorName, Affiliation)						   "
						+ "VALUES ('david@author.com', 'David', 'BSU');    	   "
						
						+ "INSERT INTO Author (Email, AuthorName, Affiliation)						   "
						+ "VALUES ('donald@author.com', 'Donald', 'CSU');    	   "
						
						+ "INSERT INTO Author (Email, AuthorName, Affiliation)						   "
						+ "VALUES ('dave@author.com', 'Dave', 'DSU');    	   "
						
						+ "INSERT INTO Author (Email, AuthorName, Affiliation)						   "
						+ "VALUES ('donovan@author.com', 'Donovan', 'ESU');    	   "
						
						+ "INSERT INTO Author (Email, AuthorName, Affiliation)						   "
						+ "VALUES ('donna@author.com', 'Donna', 'FSU');    	   "
						
						+ "INSERT INTO Author (Email, AuthorName, Affiliation)						   "
						+ "VALUES ('debbie@author.com', 'Debbie', 'GSU');    	   "

						+ "INSERT INTO Author (Email, AuthorName, Affiliation)						   "
						+ "VALUES ('damian@author.com', 'Damian', 'HSU');    	   "
						
						+ "INSERT INTO Author (Email, AuthorName, Affiliation)						   "
						+ "VALUES ('dan@author.com', 'Dan', 'ISU');    	   "
						
						+ "INSERT INTO Author (Email, AuthorName, Affiliation)						   "
						+ "VALUES ('don@author.com', 'Don', 'JSU');    	   "
						
						+ "CREATE TABLE Writes(                                            "
						+ "	PaperID 	INTEGER,                                           "
						+ "	Email 		VARCHAR(50),                                       "
						+ "	AuthorOrder INTEGER,                                           "
						+ "	PRIMARY KEY (PaperID, Email),                                  "
						+ "	FOREIGN KEY (PaperID) REFERENCES Paper(PaperID),               "
						+ "	FOREIGN KEY (Email) REFERENCES Author(Email)                   "
						+ ");                                                              "

						+ "INSERT INTO Writes (PaperID, Email, AuthorOrder)						   "
						+ "VALUES (1, 'don@author.com', 1);    	   "

						+ "INSERT INTO Writes (PaperID, Email, AuthorOrder)						   "
						+ "VALUES (1, 'dan@author.com', 2);    	   "

						+ "INSERT INTO Writes (PaperID, Email, AuthorOrder)						   "
						+ "VALUES (2, 'dan@author.com', 1);    	   "

						+ "INSERT INTO Writes (PaperID, Email, AuthorOrder)						   "
						+ "VALUES (2, 'don@author.com', 2);    	   "

						+ "INSERT INTO Writes (PaperID, Email, AuthorOrder)						   "
						+ "VALUES (2, 'damian@author.com', 3);    	   "

						+ "INSERT INTO Writes (PaperID, Email, AuthorOrder)						   "
						+ "VALUES (3, 'damian@author.com', 1);    	   "
						
						+ "INSERT INTO Writes (PaperID, Email, AuthorOrder)						   "
						+ "VALUES (4, 'debbie@author.com', 1);    	   "

						+ "INSERT INTO Writes (PaperID, Email, AuthorOrder)						   "
						+ "VALUES (5, 'donna@author.com', 1);    	   "
						
						+ "INSERT INTO Writes (PaperID, Email, AuthorOrder)						   "
						+ "VALUES (6, 'donovan@author.com', 1);    	   "

						+ "INSERT INTO Writes (PaperID, Email, AuthorOrder)						   "
						+ "VALUES (7, 'dave@author.com', 1);    	   "

						+ "INSERT INTO Writes (PaperID, Email, AuthorOrder)						   "
						+ "VALUES (8, 'donald@author.com', 1);    	   "
						
						+ "INSERT INTO Writes (PaperID, Email, AuthorOrder)						   "
						+ "VALUES (9, 'david@author.com', 1);    	   "

						+ "INSERT INTO Writes (PaperID, Email, AuthorOrder)						   "
						+ "VALUES (10, 'drake@author.com', 1);    	   "

						
						+ "CREATE TABLE PCMember(                                          "
						+ "	Email 		VARCHAR(50),                                       "
						+ "	MemberName 	VARCHAR(20),                                       "
						+ "	PRIMARY KEY (email)		                                       "
						+ ");                                                              "

						+ "INSERT INTO PCMember (Email, MemberName)						   "
						+ "VALUES ('john@test.com', 'John');	    	   				   "

						+ "INSERT INTO PCMember (Email, MemberName)						   "
						+ "VALUES ('joe@test.com', 'Joe');	    	   					   "

						+ "INSERT INTO PCMember (Email, MemberName)						   "
						+ "VALUES ('james@test.com', 'James');	    	   				   "

						+ "INSERT INTO PCMember (Email, MemberName)						   "
						+ "VALUES ('jake@test.com', 'Jake');	    	   				   "

						+ "INSERT INTO PCMember (Email, MemberName)						   "
						+ "VALUES ('jim@test.com', 'Jim');	    	    				   "

						+ "INSERT INTO PCMember (Email, MemberName)						   "
						+ "VALUES ('johnny@test.com', 'Johnny');	   					   "

						+ "INSERT INTO PCMember (Email, MemberName)						   "
						+ "VALUES ('joey@test.com', 'Joey');	    	   				   "

						+ "INSERT INTO PCMember (Email, MemberName)						   "
						+ "VALUES ('jimmy@test.com', 'Jimmy');	    	   				   "

						+ "INSERT INTO PCMember (Email, MemberName)						   "
						+ "VALUES ('jacob@test.com', 'Jacob');	    	   				   "

						+ "INSERT INTO PCMember (Email, MemberName)						   "
						+ "VALUES ('joseph@test.com', 'Joseph');	 	   				   "

						+ "CREATE TABLE Review(                                            "
						+ "	ReportID 	INTEGER AUTO_INCREMENT,                            "
						+ "	SubDate 	DATE,                                              "
						+ "	Comment		VARCHAR(250),                                      "
						+ "	Recommend	CHAR(1),                                           "
						+ "	PaperID 	INTEGER,                                           "
						+ "	Email 		VARCHAR(100),                                      "
						+ " PRIMARY KEY (ReportID),										   "
						+ "	FOREIGN KEY (PaperID) REFERENCES Paper(PaperID),               "
						+ "	FOREIGN KEY (Email) REFERENCES PCMember(Email),                "
						+ "	UNIQUE (PaperID, Email)                                        "
						+ ");"						

						+ "INSERT INTO Review (Subdate, Comment, Recommend, PaperID, Email)						   "
						+ "VALUES ('2017-11-1', 'Comment on paper', 'T', 2, 'joseph@test.com');	 	   				   "

						+ "INSERT INTO Review (Subdate, Comment, Recommend, PaperID, Email)						   "
						+ "VALUES ('2017-11-1', 'Comment on paper', 'T', 2, 'john@test.com');	 	   				   "

						+ "INSERT INTO Review (Subdate, Comment, Recommend, PaperID, Email)						   "
						+ "VALUES ('2017-11-1', 'Comment on paper', 'T', 2, 'jacob@test.com');	 	   				   "

						+ "INSERT INTO Review (Subdate, Comment, Recommend, PaperID, Email)						   "
						+ "VALUES ('2017-11-1', 'Comment on paper', 'F', 4, 'joseph@test.com');	 	   				   "

						+ "INSERT INTO Review (Subdate, Comment, Recommend, PaperID, Email)						   "
						+ "VALUES ('2017-11-1', 'Comment on paper', 'F', 4, 'john@test.com');	 	   				   "

						+ "INSERT INTO Review (Subdate, Comment, Recommend, PaperID, Email)						   "
						+ "VALUES ('2017-11-1', 'Comment on paper', 'F', 4, 'jacob@test.com');	 	   				   "
				
						+ "INSERT INTO Review (Subdate, Comment, Recommend, PaperID, Email)						   "
						+ "VALUES ('2017-11-1', 'Comment on paper', 'T', 6, 'joseph@test.com');	 	   				   "

						+ "INSERT INTO Review (Subdate, Comment, Recommend, PaperID, Email)						   "
						+ "VALUES ('2017-11-1', 'Comment on paper', 'T', 6, 'john@test.com');	 	   				   "

						+ "INSERT INTO Review (Subdate, Comment, Recommend, PaperID, Email)						   "
						+ "VALUES ('2017-11-1', 'Comment on paper', 'F', 6, 'jacob@test.com');	 	   				   "
				
						+ "INSERT INTO Review (Subdate, Comment, Recommend, PaperID, Email)						   "
						+ "VALUES ('2017-11-1', 'Comment on paper', 'F', 8, 'joseph@test.com');	 	   				   "

						+ "INSERT INTO Review (Subdate, Comment, Recommend, PaperID, Email)						   "
						+ "VALUES ('2017-11-1', 'Comment on paper', 'T', 8, 'john@test.com');	 	   				   "

						+ "INSERT INTO Review (Subdate, Comment, Recommend, PaperID, Email)						   "
						+ "VALUES ('2017-11-1', 'Comment on paper', 'F', 8, 'jacob@test.com');	 	   				   "
				
						+ "INSERT INTO Review (Subdate, Comment, Recommend, PaperID, Email)						   "
						+ "VALUES ('2017-11-1', 'Comment on paper', 'T', 10, 'joseph@test.com');	 	   				   "

						+ "INSERT INTO Review (Subdate, Comment, Recommend, PaperID, Email)						   "
						+ "VALUES ('2017-11-1', 'Comment on paper', 'T', 10, 'james@test.com');	 	   				   "

						+ "INSERT INTO Review (Subdate, Comment, Recommend, PaperID, Email)						   "
						+ "VALUES ('2017-11-1', 'Comment on paper', 'T', 10, 'jacob@test.com')	 	   				   "
				
				)
				.split(";");


		try (Connection connect = ConnectionManager.getConnection()) {
			for (int i = 0; i < scanner.length; ++i) {
				String sqlStatement = scanner[i];
				try {
					statement = connect.createStatement();
					statement.execute(sqlStatement);
				} finally {
					if (statement != null) {
						statement.close();
					}
					statement = null;
				}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			  response.setContentType("text/html");
			  PrintWriter out = response.getWriter();
			  out.append("Success");
			  out.close();
		}
	}
}