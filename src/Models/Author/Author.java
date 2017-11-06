package Models.Author;

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
	public String Email;
	public String AuthorName;
	public String Affiliation;
}
