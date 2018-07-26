package com.iii.cb102stevelee;

import java.sql.*;

// Query all employees using Statement
// 自JDBC4.0開始 ，無需顯性地(explictly)使用Class.forName()來載入JDBC Driver
public class QueryDemo2 {
	public static void main(String[] args) {
		Connection conn = null;// outside try block to declare cnn with initial value null.
		try {     
			String connUrl = "jdbc:mysql://localhost:3306/jdbc";
			conn = DriverManager.getConnection(connUrl, "sa", "passw0rd");
			
			String qryStmt = "SELECT ename, salary FROM employee";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(qryStmt);

			while(rs.next()) {
				System.out.print("name = " + rs.getString("ename") + ", ");
				System.out.println("salary = " + rs.getDouble("salary"));
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) // error" cnn can't be resolved to a variable since cnn in try block
				try {
					conn.close();
				} catch(SQLException e) { 
					e.printStackTrace();
				}
		}
	}// end of main()
}// end of class QueryDemo2
