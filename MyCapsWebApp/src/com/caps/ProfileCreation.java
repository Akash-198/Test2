package com.caps;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/create_profile")
public class ProfileCreation extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String sid=req.getParameter("sid");
			String fname=req.getParameter("firstname");
			String lname=req.getParameter("lastname");
			String gender=req.getParameter("gender");
			String password=req.getParameter("password");
			String type=req.getParameter("type");
			
			Connection con = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			
			try {
				/*
				 * 1. Load the Driver
				 */
				Driver driverRef= new com.mysql.jdbc.Driver();
				DriverManager.registerDriver(driverRef);
				Class.forName("com.mysql.jdbc.Driver");
				
				/*
				 * 2. Get the DB Connection via Driver
				 */
							String dbUrl="jdbc:mysql://localhost:3306/capsv4_db?user=Akash&password=mysql";
		
					con = DriverManager.getConnection(dbUrl);
				
				System.out.println("Connected...");
				
				/*
				 * 3. Issue the SQL query via connection
				 */
				String sql = "insert into students_info values(?,?,?,?,?,?)";

				stmt = con.prepareStatement(sql);
				stmt.setInt(1, Integer.parseInt(sid));
				stmt.setString(2, fname);
				stmt.setString(3, lname);
				stmt.setString(4, gender);
				stmt.setString(5, password);
				stmt.setString(6, type);
				
				int count = stmt.executeUpdate();

				/*
				 * 4. Process the results
				 */
				PrintWriter out=resp.getWriter();
				if(count>0) {
					out.println("Profile Created");
				}else {
					out.print("Profile creation failed");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
					
		
	}
}
