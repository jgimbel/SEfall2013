package edu.ucollege.tech.Connections;
import java.sql.*;


public class MySQL {
	Connection con = null;
    Statement st = null;
    ResultSet rs = null;

    String url = "jdbc:mysql://localhost:3306/test";
    String user = "root";
    String password = "loot";
	String driver = "com.mysql.jdbc.Driver";

	public MySQL(){	}
	
	public String getArticles(){
		String toReturn = "";
		try {
			Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
			st = con.createStatement();
			st.execute("SELECT * FROM test.article");
			rs = st.getResultSet();
	            while (rs.next()) {
	                toReturn += rs.getInt(1);
	                toReturn += ": ";
	                toReturn += rs.getString(2) + "\n";
	            }
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println(e.toString());
		}  finally {

            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
               ex.printStackTrace();
            }
        }
		
		return toReturn;
	}
}
