package Models.Paper;

import MySqlAnnotations.*;

@TableName("paper")
public class Paper {
	public int id;
	public String title;
	public String paperAbstract;
	public String pdf;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPaperAbstract() {
		return paperAbstract;
	}
	public void setPaperAbstract(String paperAbstract) {
		this.paperAbstract = paperAbstract;
	}
	public String getPdf() {
		return pdf;
	}
	public void setPdf(String pdf) {
		this.pdf = pdf;
	}

}
