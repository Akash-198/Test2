package com.caps;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/loginServ")
public class LoginServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String userId=req.getParameter("username");
		String password=req.getParameter("password");
		
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
			String sql = "select * from students_info where sid=? and password=?";

			stmt = con.prepareStatement(sql);
			stmt.setInt(1, Integer.parseInt(userId));
			stmt.setString(2, password);
			rs = stmt.executeQuery();

			/*
			 * 4. Process the results
			 */
			PrintWriter out=resp.getWriter();

			if(rs.next()){
				HttpSession session=req.getSession();
				int regno = rs.getInt("sid");
				String firstname = rs.getString("firstname");
				String lastname = rs.getString("lastname");
				String gender = rs.getString("gender");
				String passwd = rs.getString("password");
				String type = rs.getString("type");

				out.println(regno);
				out.println(firstname);
				out.println(lastname);
			    out.println(gender);
				out.println(passwd);
				out.println(type);
				out.println("*********************");
			}
			else {
				out.println("login failed");
			}
			out.println("<a href='/viewAllStudents'>view all students</a>");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
