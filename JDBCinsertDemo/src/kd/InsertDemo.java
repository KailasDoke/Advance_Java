package kd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertDemo {
	public static void main(String[] args) throws Exception {
		// user input --------------------------------
		String name ="Ganesh";
		String gmail = "ganesh@1231";
		String pass = "1233";
		String Gender = "Male";
		String City = "Jalna";
		
		// Load JDBC Drivers  -----------------------------
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		// Connection with SQL ------------------------------
		
		Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db","root","Kailas@2004");
		
		// Place Holders 
		String ins ="Insert into register values(?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(ins);
		
		ps.setString(1, name);
		ps.setString(2, gmail);
		ps.setString(3, pass);
		ps.setString(4, Gender);
		ps.setString(5, City);
		
		
			int count =ps.executeUpdate(); // executeUpdate() -> Returns int value 
			if(count>0) {
				System.out.println("sussfully inserted");
			}
			else {
				System.out.println(" not  sussfully inserted");
			}
			con.close();
	}
		
}
