package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Statement;
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
						+ "DROP VIEW IF EXISTS recommended_papers;"
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

						+ "CREATE TABLE Author	(                                          "
						+ " authorid INTEGER AUTO_INCREMENT, "
						+ "	Email 		VARCHAR(100),                                      "
						+ "	AuthorName 	VARCHAR(50),                                       "
						+ "	Affiliation VARCHAR(100),                                      "
						+ " UNIQUE(email), 													"
						+ "	PRIMARY KEY (authorid)                                          "
						+ ");                                                              "

						+ "INSERT INTO Author (Email, AuthorName, Affiliation)						   "
						+ "VALUES ('drake@author.com', 'Drake', 'ASU');    	   "

						+ "INSERT INTO Author (Email, AuthorName, Affiliation)						   "
						+ "VALUES ('zhang@author.com', 'Zhang', 'BSU');    	   "

						+ "INSERT INTO Author (Email, AuthorName, Affiliation)						   "
						+ "VALUES ('lu@author.com', 'Lu', 'CSU');    	   "

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
						+ "	AuthorID 	INTEGER,                                       "
						+ "	AuthorOrder INTEGER,                                           "
						+ "	PRIMARY KEY (PaperID, authorid),                                  "
						+ "	FOREIGN KEY (PaperID) REFERENCES Paper(PaperID) ON DELETE CASCADE,               "
						+ "	FOREIGN KEY (AuthorID) REFERENCES Author(AuthorID) ON DELETE CASCADE                  "
						+ ");                                                              "

						+ "INSERT INTO Writes (PaperID, authorid, AuthorOrder)						   "
						+ "VALUES (1, 1, 0);    	   "

						+ "INSERT INTO Writes (PaperID, authorid, AuthorOrder)						   "
						+ "VALUES (1, 2, 1);    	   "

						+ "INSERT INTO Writes (PaperID, authorid, AuthorOrder)						   "
						+ "VALUES (2, 2, 2);    	   "

						+ "INSERT INTO Writes (PaperID, authorid, AuthorOrder)						   "
						+ "VALUES (2, 1, 1);    	   "

						+ "INSERT INTO Writes (PaperID, authorid, AuthorOrder)						   "
						+ "VALUES (2, 3, 0);    	   "

						+ "INSERT INTO Writes (PaperID, authorid, AuthorOrder)						   "
						+ "VALUES (3, 3, 0);    	   "

						+ "INSERT INTO Writes (PaperID, authorid, AuthorOrder)						   "
						+ "VALUES (4, 4, 0);    	   "

						+ "INSERT INTO Writes (PaperID, authorid, AuthorOrder)						   "
						+ "VALUES (5, 5, 0);    	   "

						+ "INSERT INTO Writes (PaperID, authorid, AuthorOrder)						   "
						+ "VALUES (6, 6, 0);    	   "

						+ "INSERT INTO Writes (PaperID, authorid, AuthorOrder)						   "
						+ "VALUES (7, 7, 0);    	   "

						+ "INSERT INTO Writes (PaperID, authorid, AuthorOrder)						   "
						+ "VALUES (8, 8, 0);    	   "

						+ "INSERT INTO Writes (PaperID, authorid, AuthorOrder)						   "
						+ "VALUES (9, 9, 0);    	   "

						+ "INSERT INTO Writes (PaperID, authorid, AuthorOrder)						   "
						+ "VALUES (10, 10, 0);    	   "

						+ "CREATE TABLE PCMember(                                          "
						+ "	PCMemberID	INTEGER	AUTO_INCREMENT,							   "
						+ "	Email 		VARCHAR(50),                                       "
						+ "	MemberName 	VARCHAR(20),                                       "
						+ "	PRIMARY KEY (PCMemberID),		                                       "
						+ " UNIQUE (Email)                                                 "
						+ ");                                                              "

						+ "INSERT INTO PCMember (Email, MemberName)						   "
						+ "VALUES ('john@test.com', 'John');	    	   				   "

						+ "INSERT INTO PCMember (Email, MemberName)						   "
						+ "VALUES ('matt@test.com', 'Matt');	    	   					   "

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
						+ "	ReviewId 	INTEGER AUTO_INCREMENT,                            "
						+ "	SubDate 	DATE,                                              "
						+ "	Comment		VARCHAR(250),                                      "
						+ "	Recommend	CHAR(1),                                           "
						+ "	PaperID 	INTEGER,                                           "
						+ "	PCMemberID 	INTEGER,                                      		"
						+ " PRIMARY KEY (reviewid),										   "
						+ "	FOREIGN KEY (PaperID) REFERENCES Paper(PaperID) ON DELETE CASCADE,               "
						+ "	FOREIGN KEY (PCMemberID) REFERENCES PCMember(PCMemberID) ON DELETE CASCADE,                "
						+ "	UNIQUE (PaperID, PCMemberID)                                        "
						+ ");"

						+ "INSERT INTO Review (Subdate, Comment, Recommend, PaperID, PCMemberID)	   "
						+ "VALUES ('2017-11-1', 'Comment on paper', '1', 2, 1);	 	   				   "

						+ "INSERT INTO Review (Subdate, Comment, Recommend, PaperID, PCMemberID)	   "
						+ "VALUES ('2017-11-1', 'Comment on paper', '1', 2, 2);	 	   				   "

						+ "INSERT INTO Review (Subdate, Comment, Recommend, PaperID, PCMemberID)	   "
						+ "VALUES ('2017-11-1', 'Comment on paper', '1', 2, 3);	 	   				   "

						+ "INSERT INTO Review (Subdate, Comment, Recommend, PaperID, PCMemberID)	   "
						+ "VALUES ('2017-11-1', 'Comment on paper', '0', 4, 1);	 	   				   "

						+ "INSERT INTO Review (Subdate, Comment, Recommend, PaperID, PCMemberID)	   "
						+ "VALUES ('2017-11-1', 'Comment on paper', '0', 4, 2);	 	   				   "

						+ "INSERT INTO Review (Subdate, Comment, Recommend, PaperID, PCMemberID)	   "
						+ "VALUES ('2017-11-1', 'Comment on paper', '0', 4, 3);	 	   				   "

						+ "INSERT INTO Review (Subdate, Comment, Recommend, PaperID, PCMemberID)	   "
						+ "VALUES ('2017-11-1', 'Comment on paper', '1', 6, 1);	 	   				   "

						+ "INSERT INTO Review (Subdate, Comment, Recommend, PaperID, PCMemberID)	   "
						+ "VALUES ('2017-11-1', 'Comment on paper', '1', 6, 3); 	   				       "

						+ "INSERT INTO Review (Subdate, Comment, Recommend, PaperID, PCMemberID)	   "
						+ "VALUES ('2017-11-1', 'Comment on paper', '1', 6, 2);	 	   				   "

						+ "INSERT INTO Review (Subdate, Comment, Recommend, PaperID, PCMemberID)	   "
						+ "VALUES ('2017-11-1', 'Comment on paper', '1', 8, 4);	 	   				   "

						+ "INSERT INTO Review (Subdate, Comment, Recommend, PaperID, PCMemberID)	   "
						+ "VALUES ('2017-11-1', 'Comment on paper', '1', 8, 5);	 	   				   "

						+ "INSERT INTO Review (Subdate, Comment, Recommend, PaperID, PCMemberID)	   "
						+ "VALUES ('2017-11-1', 'Comment on paper', '0', 8, 6);	 	   				   "

						+ "INSERT INTO Review (Subdate, Comment, Recommend, PaperID, PCMemberID)	   "
						+ "VALUES ('2017-11-1', 'Comment on paper', '1', 10, 4);	 	   			   "

						+ "INSERT INTO Review (Subdate, Comment, Recommend, PaperID, PCMemberID)	   "
						+ "VALUES ('2017-11-1', 'Comment on paper', '1', 10, 5);	 	   			   "

						+ "INSERT INTO Review (Subdate, Comment, Recommend, PaperID, PCMemberID)	   "
						+ "VALUES ('2017-11-1', 'Comment on paper', '1', 10, 6);	 	   			   "

						+ " CREATE VIEW recommended_papers AS " + " Select * "
						+ " from paper " + " Where paperID IN "
						+ " (select P.paperID " + " from paper P, review R "
						+ " Where R.Recommend='1' "
						+ " AND P.paperID=R.PaperID " + " Group by P.paperID "
						+ " having count(*)>1) "

		).split(";");

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

			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.append("Success");
			out.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.append("Failed: " + e.getMessage());
			out.close();
			e.printStackTrace();
		} finally {

		}
	}
}