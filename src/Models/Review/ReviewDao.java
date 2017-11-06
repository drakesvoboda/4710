package Models.Review;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import Models.Review.Review;
import Dao.Dao;
import Dao.IMapper;

public class ReviewDao extends Dao<Review, String> {

	private static IMapper<Review> WRITES_MAPPER = new IMapper<Review>(){
		@Override
		public Review map(ResultSet resultSet) throws SQLException{
			Review review = new Review();
						
			review.setReportID(resultSet.getInt("reportid"));
			review.setSubDate(resultSet.getDate("subdate"));
			review.setComment(resultSet.getString("comment"));
			review.setRecommend(resultSet.getBoolean("recommend"));
			review.setPaperID(resultSet.getInt("paperid"));
			review.setEmail(resultSet.getString("email"));
			
			return review;			
		}
	};
	
	
	public ReviewDao() {
		super(WRITES_MAPPER);
	}	

}
