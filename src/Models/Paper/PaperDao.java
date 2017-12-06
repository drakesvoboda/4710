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
	
	public List<Paper> getPapersRejectedBy(String member1, String member2){
		return select("select * "
						+"from review R1,review R2, paper P, pcmember PC1, pcmember PC2 "
						+"where R1.Recommend='F' "
						+"AND R2.Recommend='F' "
						+"AND PC1.MemberName=? "
						+"AND PC2.MemberName=? "
								+"AND R1.PaperID=R2.PaperID "
								+"AND R1.pcmemberid=PC1.pcmemberid "
								+"AND R2.pcmemberid=PC2.pcmemberid "
								+"AND P.PaperID=R1.PaperID AND R1.reviewid != R2.reviewid", member1, member2);		
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
						+ "		having count(W.Email)=1)) ", authorname);
	}
	
	public List<Paper> getPapersByTwoAuthors(String authorname1, String authorname2){
		return select( "SELECT * FROM paper WHERE paperid IN "
				+ " (SELECT w.paperid FROM writes w, author a WHERE w.email = a.email AND a.authorname = ?) "
				+ " AND paperid IN "
				+ " (SELECT w.paperid FROM writes w, author a WHERE w.email = a.email AND a.authorname = ?) "
				, authorname1,
				authorname2);
	}
}
