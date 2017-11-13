package Servlets;

import java.io.IOException;
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
)
				.split(";");

		try (Connection connect = ConnectionManager.getConnection()) {
			for (int i = 0; i < scanner.length; ++i) {
				String sqlStatement = scanner[i] + ";";
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
		}
		/*
		PaperDao paperdao = new PaperDao();
		
		Paper paper = new Paper();
		
		paper.setTitle("test create");
		
		paper.setPaperAbstract("test create abst");
		
		paper.setPdf("test create pdf");
		
		paperdao.create(paper);
		*/
		

	}
}