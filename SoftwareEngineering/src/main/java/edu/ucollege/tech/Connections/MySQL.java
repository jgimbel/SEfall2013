package edu.ucollege.tech.Connections;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.ucollege.tech.OM.Person;

import javax.sql.DataSource;

public class MySQL{
	private DataSource dataSource;
 
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public Person login(String name, String password){
		String sql = String.format("Select * FROM students Where FirstName= '%s' AND Password = '%s'", name, password);
		ResultSet result = this.Select(sql);
		
		try {
			result.first();
			if(result.isLast()){
			return new Person(result.getInt(1), result.getString(2), result.getString(3), true);
			}else {
				sql = "Select * FROM teachers Where FirstName= '%s' AND password = '%s'";
				result = this.Select(sql);
				result.first();
				if(result.isLast()){
					return new Person(result.getInt(1), result.getString(2), result.getString(3), false);	
				}else {
					return null;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}

	public Person getStudent(int ID){
		String sql = "SELECT * FROM students WHERE ID = " + ID;
		ResultSet rs = this.Select(sql);
		try{
			rs.first();
			if(rs.isLast()){
				return new Person(rs.getInt(1), rs.getString(2), rs.getString(3), true);
			}
		}catch(Exception e){}
		
		return null;
		
	}
	public Person getTeacher(int ID){
		String sql = "SELECT * FROM teachers WHERE ID = " + ID;
		ResultSet rs = this.Select(sql);
		try{
			rs.first();
			if(rs.isLast()){
				return new Person(rs.getInt(1), rs.getString(2), rs.getString(3), false);
			}
		}catch(Exception e){}
		
		return null;
		
	}
	
	public ResultSet Select(String sql){
		ResultSet rs = null;
		
		Connection conn = null;
 
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			ps.close();
 
		} catch (SQLException e) {
			throw new RuntimeException(e);
 
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
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