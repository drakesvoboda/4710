package Models.Writes;

import java.io.Serializable;

import MySqlAnnotations.*;

@TableName("writes")
public class Writes {
	
	@PrimaryKey
	@ColumnName("paperid")
	public int PaperId;
	@PrimaryKey
	@ColumnName("email")
	public String Email;
	@ColumnName("authororder")
	public int AuthorOrder;
	
	public static class WritesPK{
		public String Email;
		public int PaperId;
	}
	
	public int getPaperId() {
		return PaperId;
	}
	public void setPaperId(int paperId) {
		PaperId = paperId;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public int getAuthorOrder() {
		return AuthorOrder;
	}
	public void setAuthorOrder(int authorOrder) {
		AuthorOrder = authorOrder;
	}
	
}
