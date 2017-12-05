package Models.PCMember;

import MySqlAnnotations.*;

@TableName("PCMember")
public class PCMember {
	
	@PrimaryKey
	@ColumnName("id")
	public int id;
	
	@ColumnName("email")
	public String email;
	
	@ColumnName("membername")
	public String memberName;

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
}
