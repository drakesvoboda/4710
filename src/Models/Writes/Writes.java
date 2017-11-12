package Models.Writes;

import java.io.Serializable;

import MySqlAnnotations.*;

public class Writes {
	
	@PrimaryKey
	public int PaperId;
	@PrimaryKey
	public String Email;
	
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
