package edu.ucollege.tech.OM;

import edu.ucollege.tech.Connections.MySQL;

public class Article {
	private String URL;
	private String title;
	private String Date;
	private int ClassID;
	private int ID;
	
	public Article(int ID) throws Exception{
		this.clone(new MySQL().getArticle(ID));
	}
	public Article(int ID, String url, String title, String Date, int ClassID){
		this.ID = ID;
		this.URL = url;
		this.title = title;
		this.Date = Date;
		this.ClassID = ClassID;
	}
	
	public Article(String url, String title, int ClassID){
		this.URL = url;
		this.title = title;
		this.Date = null;
		this.ClassID = ClassID;
	}
	
	public void save(){
		new MySQL().saveArticle(this);
	}
	
	public void clone(Article a) throws Exception{
		if(a == null){
			throw new Exception("Login Failed");
		}else{
			this.ID = a.getID();
			this.URL = a.URL;
			this.title = a.title;
			this.Date = a.Date;
			this.ClassID = a .ClassID;
		}
	}
	
	
	//////////////////////////////////////getters and setters//////////////////////////////////
	
	public int getID() {
		return ID;
	}
	public String getURL() {
		return URL;
	}
	public void setURL(String uRL) {
		URL = uRL;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public int getClassID() {
		return ClassID;
	}
	public void setClassID(int classID) {
		ClassID = classID;
	}
	
}
