package com.iii.cb102stevelee;

import java.sql.*;

// Query all employees using PrepareStatement
public class QueryDemo4 {
	public static void main(String[] args) {
		Connection conn = null;
		try {     
			String connUrl = "jdbc:mysql://localhost:3306/jdbc?useSSL=false&serverTimezone=UTC";
			conn = DriverManager.getConnection(connUrl, "root", "steve1924");
			
			String qryStmt = "SELECT ename, salary FROM employee";
			PreparedStatement pstmt = conn.prepareStatement(qryStmt);
			// PreparedStatement usage as Statement(extends Statement)
			ResultSet rs = pstmt.executeQuery();                     
			//none in ()
			while(rs.next()) {
				System.out.print("name = " + rs.getString("ename") + ", ");
				System.out.println("salary = " + rs.getDouble("salary"));
			}
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null)
				try {
					conn.close();
				} catch(SQLException e) { 
					e.printStackTrace();
				}
		}
	}// end of main()
}// end of class QueryDemo4
