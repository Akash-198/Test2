package com.demojdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DemoAddBatch {

	public static void main(String[] args) {
		
		Connection con=null;
		Statement stmt=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String url="jdbc:mysql://localhost:3306/capsv4_db";
			con=DriverManager.getConnection(url, "Akash", "mysql");
			
			con.setAutoCommit(false);
			stmt=con.createStatement();
			String sql="insert into emp_info values(7,'akash','asdf',5555)";
			stmt.addBatch(sql);
			//int i=45/0;
			sql="insert into emp_info values(10,'akash','sdf',6465)";
			stmt.addBatch(sql);
			
			stmt.executeBatch();
			con.commit();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
