package Models.Review;

import java.util.Date;

import MySqlAnnotations.*;

@TableName("review")
public class Review {
	
	@PrimaryKey
	public int ReportID;
	
	public Date SubDate;
	public String Comment;
	public boolean Recommend;
	
	
	@ForeignKey(ForeignColumn = "PaperID", ForeignTable = "paper")
	public int PaperID;
	
	public String Email;
	
	public int getReportID() {
		return ReportID;
	}
	public void setReportID(int reportID) {
		ReportID = reportID;
	}
	public Date getSubDate() {
		return SubDate;
	}
	public void setSubDate(Date subDate) {
		SubDate = subDate;
	}
	public String getComment() {
		return Comment;
	}
	public void setComment(String comment) {
		Comment = comment;
	}
	public boolean isRecommend() {
		return Recommend;
	}
	public void setRecommend(boolean recommend) {
		Recommend = recommend;
	}
	public int getPaperID() {
		return PaperID;
	}
	public void setPaperID(int paperID) {
		PaperID = paperID;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
}
