package edu.ucollege.tech.OM;

import edu.ucollege.tech.Connections.MySQL;

public class Class {

	private int ID;
	private int Teacher;
	private String Name;
	private String Code;
	
	
	public Class(int ID){
		try {
			this.clone(new MySQL().getClass(ID));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Class(int ID, int Teacher, String Name, String Code){
		this.ID = ID;
		this.Teacher = Teacher;
		this.Name=Name;
		this.Code=Code;
	}
	
	public void clone(Class c) throws Exception{
		if(c == null){
			throw new Exception("Login Failed");
		}else{
			this.ID = c.ID;
			this.Teacher = c.Teacher;
			this.Name=c.Name;
			this.Code=c.Code;
		}
	}

	
	//////////////////////////////////getters and setters////////////////////////////////
	public int getTeacher() {
		return Teacher;
	}
	public void setTeacher(int teacher) {
		Teacher = teacher;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getCode() {
		return Code;
	}
	public void setCode(String code) {
		Code = code;
	}
	public int getID() {
		return ID;
	}


	
}
