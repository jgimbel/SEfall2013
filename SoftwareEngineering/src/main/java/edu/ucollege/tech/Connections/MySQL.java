package edu.ucollege.tech.Connections;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import edu.ucollege.tech.OM.Person;

public class MySQL{
	private String url = "jdbc:mysql://localhost:3306/test";
	private String name = "root";
	private String password = "loot";
	public MySQL(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Person login(String name, String password) throws Exception{
		String sql = String.format("Select * FROM students Where Email='%s' AND Password='%s'", name, password);
//		String sql = "Select * FROM students";
		ResultSet result = this.Select(sql);
		
		try {
			if(!result.next()){
				return new Person(result.getInt(1), result.getString(2), result.getString(3), true);
			}else {
				sql = "Select * FROM teachers Where Email= '%s' AND password = '%s'";
				result = this.Select(sql);
				result.first();
				if(result.isLast()){
					return new Person(result.getInt(1), result.getString(2), result.getString(3), false);	
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
				return new Person(rs.getInt(1), rs.getString(2), rs.getString(3), true);
			}
		}catch(Exception e){}
		
		return null;
		
	}
	public Person getTeacher(int ID){
		String sql = "SELECT * FROM teachers WHERE ID = " + ID;
		try{
			ResultSet rs = this.Select(sql);
			rs.first();
			if(rs.isLast()){
				return new Person(rs.getInt(1), rs.getString(2), rs.getString(3), false);
			}
		}catch(Exception e){}
		return null;
	}
	
	public ResultSet Select(String sql) throws Exception{
		ResultSet rs = null;
		
		Connection conn = null;
 
		try {
			conn = DriverManager.getConnection(url, name, password);
			Statement ps = conn.createStatement();
			ps.executeQuery(sql);
			rs = ps.getResultSet();
			System.out.println(rs.getInt(1));
			//ps.close();
 
		} catch (SQLException e) {
			throw new Exception(e.toString());
 
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					throw new Exception(e.toString());
				}
			}
		}
		return rs;
	}
 
//	public Articles findByCustomerId(int ArtID){
// 
//		String sql = "SELECT * FROM CUSTOMER WHERE CUST_ID = ?";
// 
//		Connection conn = null;
// 
//		try {
//			conn = dataSource.getConnection();
//			PreparedStatement ps = conn.prepareStatement(sql);
//			ps.setInt(1, ArtId);
//			Customer customer = null;
//			ResultSet rs = ps.executeQuery();
//			if (rs.next()) {
//				customer = new Customer(
//					rs.getInt("CUST_ID"),
//					rs.getString("NAME"), 
//					rs.getInt("Age")
//				);
//			}
//			rs.close();
//			ps.close();
//			return customer;
//		} catch (SQLException e) {
//			throw new RuntimeException(e);
//		} finally {
//			if (conn != null) {
//				try {
//				conn.close();
//				} catch (SQLException e) {}
//			}
//		}
//	}
}