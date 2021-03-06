package Models.Author;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import Models.Author.Author;
import Dao.Dao;
import Dao.IMapper;

public class AuthorDao extends Dao<Author, String> {

	private static IMapper<Author> AUTHOR_MAPPER = new IMapper<Author>(){
		@Override
		public Author map(ResultSet resultSet) throws SQLException{
			Author author = new Author();
			
			author.setId(resultSet.getInt("authorid"));
			author.setEmail(resultSet.getString("email"));
			author.setAuthorName(resultSet.getString("authorname"));
			author.setAffiliation(resultSet.getString("affiliation"));
			
			return author;			
		}
	};
	
	
	public AuthorDao() {
		super(AUTHOR_MAPPER, Author.class);
	}	
	
	public List<Author> getAuthorByName(String authorName){	
		return select("SELECT * FROM Author WHERE authorname = ?", authorName);
	}
	
	public List<Author> getAuthorsForPaper(int paperId){
		return select("Select * From writes W, author A Where W.PaperID=? AND W.authorid=A.authorid Order by W.authorOrder asc", paperId);		
	
		
	}

}
