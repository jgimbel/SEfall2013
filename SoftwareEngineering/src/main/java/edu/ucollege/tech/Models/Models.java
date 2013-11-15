package edu.ucollege.tech.Models;

import java.util.List;



public class Models
{
	public class Article {
		private int ArtId;
		public int getId() {
			return ArtId;
		}
		public String URL;
		public String name;
		public String date;
	}
	public class Articles {
		public Articles(){}
		
		public List<Article> articles;

		
		
		//getter and setter methods
	}
 
}


