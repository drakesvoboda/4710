package Models.Author;

import MySqlAnnotations.*;

@TableName("author")
public class Author {
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getAuthorName() {
		return AuthorName;
	}
	public void setAuthorName(String authorName) {
		AuthorName = authorName;
	}
	public String getAffiliation() {
		return Affiliation;
	}
	public void setAffiliation(String affiliation) {
		Affiliation = affiliation;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@PrimaryKey
	@ColumnName("authorid")
	public int id;

	@ColumnName("email")
	public String Email;
	
	@ColumnName("authorname")
	public String AuthorName;
	
	@ColumnName("affiliation")
	public String Affiliation;
}
