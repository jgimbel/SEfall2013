package edu.ucollege.tech.OM;
import edu.ucollege.tech.Connections.MySQL;

public class Person {
	private int ID;
	public String FirstName;
	public String LastName;
	private boolean Student;
	private MySQL sql = new MySQL();
	
	
	public Person(){}
	public Person(int ID, String FirstName, String LastName, boolean Student){
		this.ID = ID;
		this.FirstName = FirstName;
		this.LastName = LastName;
		this.Student = Student;
	}
	public Person(int ID, boolean student) throws Exception{
		if(student){
			this.clone(sql.getStudent(ID));
		}else{
			this.clone(sql.getTeacher(ID));
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
}
