package Models.Paper;

import java.sql.ResultSet;
import java.sql.SQLException;

import Dao.IMapper;
import Dao.Dao;
import Models.Paper.Paper;
import MySqlAnnotations.MySqlAnnotationNotFoundException;

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
	
	
	public PaperDao() throws MySqlAnnotationNotFoundException {
		super(PAPER_MAPPER, Paper.class);
	}		
}
