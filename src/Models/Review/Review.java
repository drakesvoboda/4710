package Models.Review;

import java.util.Date;

import MySqlAnnotations.*;

@TableName("review")
public class Review {
	
	@PrimaryKey
	@ColumnName("reviewid")
	public int id;
	
	@ColumnName("subdate")
	public Date SubDate;
	
	@ColumnName("comment")
	public String Comment;
	
	@ColumnName("recommend")
	public boolean Recommend;
	
	@ColumnName("paperid")
	@ForeignKey(ForeignColumn = "paperid", ForeignTable = "paper")
	public int PaperID;
	
	@ColumnName("PCMemberId")
	@ForeignKey(ForeignColumn = "PCMemberId", ForeignTable = "pcmember")
	public int PCMemberId;
	
	public int getId() {
		return id;
	}
	public void setId(int reviewId) {
		id = reviewId;
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
	public int getPCMemberId() {
		return PCMemberId;
	}
	public void setPCMemberId(int PCMemberId) {
		this.PCMemberId = PCMemberId;
	}
}
