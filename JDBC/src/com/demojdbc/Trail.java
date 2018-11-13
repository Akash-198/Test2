package com.demojdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Trail 
{
	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String dbUrl="jdbc:mysql://localhost:3306/Capsv4_db?user=Akash&password=mysql";
			con=DriverManager.getConnection(dbUrl);
			String sql = "select * from students_info";

			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			/*
			 * 4. Process the results
			 */

			while(rs.next()){
				int regno = rs.getInt("sid");
				String firstname = rs.getString("firstname");
				String lastname = rs.getString("lastname");
				String gender = rs.getString("gender");
				String passwd = rs.getString("password");
				String type = rs.getString("type");

				System.out.println(regno);
				System.out.println(firstname);
				System.out.println(lastname);
				System.out.println(gender);
				System.out.println(passwd);
				System.out.println(type);
				System.out.println("*********************");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
