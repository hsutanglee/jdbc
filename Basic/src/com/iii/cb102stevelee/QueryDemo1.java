package com.iii.cb102stevelee;

import java.sql.*;

// Query all employees using Statement
// 採用Class Loader方式產生Driver實體，並註冊到Driver Manager的驅動程式註冊表單中
public class QueryDemo1 {
	public static void main(String[] args) {
		try {     
			Class.forName("com.mysql.cj.jdbc.Driver");
			// driver name need to comply with DB version, now 8.0, located under Referenced Libraries/
			// META-INF/service/java.sql.Driver, or use previous GetLoadedDriverNames.java to get
			String connUrl = "jdbc:mysql://localhost:3306/jdbc?useSSL=false&serverTimezone=UTC";
			//exception error: need to add "?useSSL=false&serverTimezone=UTC"
			Connection conn = DriverManager.getConnection(connUrl, "root", "steve1924");
			//MySQL login name and password
			String qryStmt = "SELECT ename, salary FROM employee";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(qryStmt);
			
			while(rs.next()) {
				System.out.print("name = " + rs.getString("ename") + ", ");
				System.out.println("salary = " + rs.getDouble("salary"));
				
			//	System.out.print("name = " + rs.getString(1) + ", ");
			//	System.out.println("salary = " + rs.getDouble(2));
			}
		
			rs.close();
			stmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}// end of main()
}// end of class QueryDemo1
