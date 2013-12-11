package edu.ucollege.tech.OM;
import edu.ucollege.tech.Connections.MySQL;

public class Person {
	private int ID;
	public String getFirstName() {
		return FirstName;
	}
	public String getLastName() {
		return LastName;
	}
	public String getEmail() {
		return Email;
	}

	public String FirstName;
	public String LastName;
	public String Email;
	public String Password;
	public Article[] library;
	private boolean Student;
	private MySQL sql = new MySQL();
	
	
	public Person(){}
	public Person(int ID, String FirstName, String LastName, String Email, boolean Student){
		this.ID = ID;
		this.FirstName = FirstName;
		this.LastName = LastName;
		this.Email = Email;
		this.Student = Student;
	}
	
	public Person(int ID, boolean student) throws Exception{
		if(student){
			this.clone(sql.getStudent(ID));
		}else{
			this.clone(sql.getTeacher(ID));
		}
	}
	
	

	public boolean Save(){
		
		if(Student){
			return sql.saveStudent(this);
		}else {
			return sql.saveTeacher(this);
		}
	}
	
	public void clone(Person p) throws Exception{
		if(p == null){
			throw new Exception("Login Failed");
		}else{
			this.ID = p.getID();
			this.FirstName = p.FirstName;
			this.LastName = p.LastName;
			this.Student = p.Student;
		}
	}
	public boolean isStudent(){
		return Student;
	}
	public boolean isTeacher(){
		return !Student;
	}
	public int getID(){
		return ID;
	}
	public void login(String FirstName, String password) throws Exception{
		this.clone(sql.login(FirstName, password));

	}
	
	public Person[] getStudents(){
		return sql.getRoster(ID);
	}
	
	public Article[] getLibrary(){	
		return sql.getArticles(this.ID);
	}

	public Class[] getClasses(){
		if(this.Student){
			//TODO get students classes sometime.
			return null;
		} else {
			return sql.getClasses(ID);
		}
	}
}
