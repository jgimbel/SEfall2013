package edu.ucollege.tech.Connections;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import edu.ucollege.tech.OM.Article;
import edu.ucollege.tech.OM.Person;
public class MySQL{
	private String url = "jdbc:mysql://localhost:3306/test";
	private String name = "root";
	private String password = "loot";
	private Connection conn;
	public MySQL(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, name, password);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Person login(String name, String password) throws Exception{
		String sql = String.format("Select * FROM students Where Email='%s' AND Password='%s'", name, password);
		ResultSet result = this.Select(sql);
		
		try {
			if(result.first()){
				return new Person(result.getInt(1), result.getString(2), result.getString(3), result.getString(4), true);
			}else {
				sql = String.format("Select * FROM teacher Where Email='%s' AND Password='%s'", name, password);
				result = this.Select(sql);
				
				if(result.first()){
					return new Person(result.getInt(1), result.getString(2), result.getString(3), result.getString(4), false);	
				}else {
					return null;
				}
			}
		} catch (NullPointerException e){
			throw new Exception("No User Found");
		} catch (Exception e) {
			throw new Exception(e.toString());
		}
		
	}

	public Person getStudent(int ID){
		String sql = "SELECT * FROM students WHERE ID = " + ID;

		try{
			ResultSet rs = this.Select(sql);
			rs.first();
			if(rs.isLast()){
				return new Person(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), true);
			}
		}catch(Exception e){}
		
		return null;
		
	}
	
	public Article getArticle(int ID){
		String sql = String.format("SELECT * FROM article WHERE ID=", ID);
		try{
			ResultSet rs = this.Select(sql);
			if(rs.first()){
				return new Article(ID, rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
			}
		}catch(Exception e){}
		return null;
	}
	
	public Person getTeacher(int ID){
		String sql = "SELECT * FROM teacher WHERE ID = " + ID;
		
		try{
			ResultSet rs = this.Select(sql);
			rs.first();
			if(rs.isLast()){
				return new Person(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), false);
			}
		}catch(Exception e){}
		return null;
	}
	
	public edu.ucollege.tech.OM.Class getClass(int ID) {
		String sql = String.format("SELECT * FROM class WHERE class.ID=%s", ID);
		try{
			ResultSet rs = this.Select(sql);
			rs.first();
			if(rs.isLast()){
				return new edu.ucollege.tech.OM.Class(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4));
			}
		}catch(Exception e){}
		return null;
	}
	
	public boolean saveArticle(Article a){
		
		String sql = String.format("INSERT INTO `test`.`students` (`URL`, `Name`, `Date`, `Class_ID`) VALUES ('%s', '%s', '%s', '%s');",a.getURL(), a.getTitle(), "NOW()", a.getClass());
		try {
			this.Insert(sql);
			return true;
		} catch (Exception e) {	
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean saveStudent(Person p) {
		
		String sql = String.format("INSERT INTO `test`.`students` (`FirstName`, `LastName`, `Email`, `Password`) VALUES ('%s', '%s', '%s', '%s');",p.FirstName, p.LastName, p.Email, p.Password);
		try {
			this.Insert(sql);
			return true;
		} catch (Exception e) {	
			e.printStackTrace();
		}
		return false;
		
		
		
	}

	public boolean saveTeacher(Person p) {
		String sql = String.format("INSERT INTO `test`.`teacher` (`FirstName`, `LastName`, `Email`, `Password`) VALUES ('%s', '%s', '%s', '%s');",p.FirstName, p.LastName, p.Email, p.Password);
		try {
			this.Insert(sql);
			return true;
		} catch (Exception e) {	
			e.printStackTrace();
		}
		return false;
	}

	public Person[] getRoster(int ID) {
		String sql = String.format("SELECT students.* FROM students, roster Where students.ID=roster.Student_ID AND roster.Teacher_ID=%s;",ID);
		ResultSet rs = null;
		try {
			rs = this.Select(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		LinkedList<Person> persons = new LinkedList<Person>(); 
		try {
			while(rs.next()){
				persons.add(new Person(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), true));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		Person[] toReturn = new Person[persons.size()];
		int x = 0;
		for(Person p : persons){
			toReturn[x] = p;
			x++;
		}
		
		return toReturn;
	}

	public edu.ucollege.tech.OM.Class[] getClasses(int ID) {
String sql =String.format("SELECT * FROM class WHERE Teacher_ID=%s", ID);
		
		ResultSet rs = null;
		try {
			rs = this.Select(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		LinkedList<edu.ucollege.tech.OM.Class> classes = new LinkedList<edu.ucollege.tech.OM.Class>(); 
		try {
			while(rs.next()){
				classes.add(new edu.ucollege.tech.OM.Class(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		edu.ucollege.tech.OM.Class[] toReturn = new edu.ucollege.tech.OM.Class[classes.size()];
		int x = 0;
		for(edu.ucollege.tech.OM.Class p : classes){
			toReturn[x] = p;
			x++;
		}
		
		return toReturn;
	
	}
	
	public Article[] getArticles(int ID){
		String sql =String.format("SELECT article.* FROM test.article, test.class WHERE %s=class.Teacher_ID AND class.ID=article.Class_ID;", ID);
		
		ResultSet rs = null;
		try {
			rs = this.Select(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		LinkedList<Article> articles = new LinkedList<Article>(); 
		try {
			while(rs.next()){
				articles.add(new Article(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		Article[] toReturn = new Article[articles.size()];
		int x = 0;
		for(Article p : articles){
			toReturn[x] = p;
			x++;
		}
		
		return toReturn;
	
	}
	private ResultSet Select(String sql) throws Exception{
		ResultSet rs = null;
		try {
			Statement ps = conn.createStatement();
			ps.executeQuery(sql);
			rs = ps.getResultSet();
 
		} catch (SQLException e) {
			throw new Exception(e.toString());
 
		}
		return rs;
	}
	private ResultSet Insert(String sql) throws Exception{
		ResultSet rs = null;
		try {
			Statement ps = conn.createStatement();
			ps.execute(sql);
			rs = ps.getResultSet();
 
		} catch (SQLException e) {
			throw new Exception(e.toString());
 
		}
		return rs;
	}






	
}