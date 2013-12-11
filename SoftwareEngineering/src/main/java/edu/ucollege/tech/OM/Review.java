package edu.ucollege.tech.OM;

import edu.ucollege.tech.Connections.MySQL;

public class Review {
	private int Student;
	private int Article;
	private String Notes;
	private String Review;
	private int ID;
	
	public Review(int ID){
		this.ID = ID;
		try {
			this.clone(new MySQL().getReview(ID));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Review(int int1, int int2, String string, String string2) {
		this.Student = int1;
		this.Article = int2;
		this.Notes = string;
		this.Review = string2;
	}
	
	
	public Review(int int1, int int2) {
		this.Student = int1;
		this.Article = int2;
		try {
			this.clone(new MySQL().getReview(int1, int2));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean Save(){
		return new MySQL().saveReview(this);
	}

	public void clone(Review r) throws Exception{
		this.Student = r.Student;
		this.Article = r.Article;
		this.Notes = r.Notes;
		this.Review = r.Review;
	}

	public int getID(){
		return ID;
	}
	
	public int getStudent() {
		return Student;
	}
	public void setStudent(int student) {
		Student = student;
	}
	public int getArticle() {
		return Article;
	}
	public void setArticle(int article) {
		Article = article;
	}
	public String getNotes() {
		return Notes;
	}
	public void setNotes(String notes) {
		Notes = notes;
	}
	public String getReview() {
		return Review;
	}
	public void setReview(String review) {
		Review = review;
	}
	
	
}
