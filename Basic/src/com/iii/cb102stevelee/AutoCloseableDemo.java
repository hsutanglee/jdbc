package com.iii.cb102stevelee;

import java.sql.*;

// Query all employees using PrepareStatement
public class AutoCloseableDemo {
	public static void main(String[] args) {
		
		String connUrl = "jdbc:mysql://localhost:3306/jdbc?useSSL=false&serverTimezone=UTC";
		try (Connection conn = DriverManager.getConnection(connUrl, "root", "steve1924"))
		//auto close need to new in try()
		
		{     
					
			String qryStmt = "SELECT ename, salary FROM employee";
			PreparedStatement pstmt = conn.prepareStatement(qryStmt);//
			ResultSet rs = pstmt.executeQuery();                     //
			while(rs.next()) {
				System.out.print("name = " + rs.getString("ename") + ", ");
				System.out.println("salary = " + rs.getDouble("salary"));
			}
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}// end of main()
}// end of class QueryDemo4
