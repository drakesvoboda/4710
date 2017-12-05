package Models.Paper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import Dao.IMapper;
import Dao.Dao;
import Models.Paper.Paper;

public class PaperDao extends Dao<Paper, Integer> {

	private static IMapper<Paper> PAPER_MAPPER = new IMapper<Paper>(){
		@Override
		public Paper map(ResultSet resultSet) throws SQLException{
			Paper paper = new Paper();
			
			paper.setId(resultSet.getInt("PaperID"));
			paper.setTitle(resultSet.getString("Title"));
			paper.setPaperAbstract(resultSet.getString("Abstract"));
			paper.setPdf(resultSet.getString("Pdf"));
			
			return paper;			
		}
	};
		
	public PaperDao() {
		super(PAPER_MAPPER, Paper.class);
	}		
	
	public List<Paper> getRecommendedPapers(){
		return select("SELECT * FROM recommended_papers");		
	}
	
	public List<Paper> getPapersByFirstAuthor(String authorname){
		return select(
				"select * from paper P, writes W, author A where A.AuthorName=? AND A.Email=W.Email AND W.PaperID=P.PaperID AND W.AuthorOrder=1",
				authorname);
	}
	
	public List<Paper> getPapersBySingleAuthor(String authorname){
		return select(
				"select * from paper where paperid in (select P.paperID "
						+ "from paper P, writes W, author A "
						+ "where A.AuthorName=? " + "	AND A.Email=W.Email "
						+ "   AND W.PaperID = P.PaperID "
						+ "	AND W.PaperID IN(select W.PaperID "
						+ "		from Writes W " + "		Group By W.PaperID "
						+ "		having count(W.Email)=1)) ", authorname)
	}
	
	public List<Paper> getPapersByTwoAuthors(String authorname1, String authorname2){
		return select(
				"select * "
						+ "from paper P, author A1, author A2, writes W1, writes W2 "
						+ "where P.PaperID=W1.PaperID "
						+ "AND A1.AuthorName=? "
						+ "AND A2.AuthorName=? "
						+ "AND A1.email=W1.email "
						+ "AND A2.email=W2.email", authorname1,
						authorname2)
	}
}
