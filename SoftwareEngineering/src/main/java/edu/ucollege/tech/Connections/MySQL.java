package edu.ucollege.tech.Connections;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.mysql.jdbc.Driver;

public class MySQL {
	Connection con = null;
    Statement st = null;
    ResultSet rs = null;

    String url = "jdbc:mysql://localhost:3306/test";
    String user = "root";
    String password = "loot";
	String driver = "com.mysql.jbcd.Driver";
	public MySQL(){
		
		try {
			Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
            st = con.createStatement();

        } catch (Exception ex) {
           ex.printStackTrace();
        } 
	}
	
	public String getArticles(){
		String toReturn = "";
		try {
			//Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
			Statement sts = con.createStatement();
			sts.execute("SELECT * FROM test.article");
	            while (rs.next()) {
	                toReturn += rs.getInt(1);
	                toReturn += ": ";
	                toReturn += rs.getString(2) + "\n";
	            }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return toReturn;
	}
}
