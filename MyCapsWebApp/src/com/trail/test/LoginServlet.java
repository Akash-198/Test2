package com.trail.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Duration;
import java.time.Instant;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/loginServ4")
public class LoginServlet extends HttpServlet
{
	int count=0;
	Instant start;
	Instant stop;
	long timediff=0L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String userId=req.getParameter("userid");
		String password=req.getParameter("password");
		PrintWriter out=resp.getWriter();
		
		if(count<3) {
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement stmt = null;
		
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
			String sql = "select * from students_info where firstname=? and password=?";

			stmt = con.prepareStatement(sql);
			stmt.setString(1,userId);
			stmt.setString(2, password);
			rs = stmt.executeQuery();

			/*
			 * 4. Process the results
			 */
			
			out.print("<html>");
			out.print("<body>");
			out.print("<nav> <a href=logout>logout</a></nav>");
			out.print("<table border='1px' cellpadding='5px' cellspacing='0px' bordercolor='black'>");
			out.print("<tr><th>SID</th><th>FNAME</th><th>LNAME</th><th>GENDER</th><th>PASSWORD</th><th>TYPE</th>");

			if(rs.next()){
				HttpSession session=req.getSession();
				session.setMaxInactiveInterval(-2);
				session.setAttribute("user", userId);
				
				int regno = rs.getInt("sid");
				String firstname = rs.getString("firstname");
				String lastname = rs.getString("lastname");
				String gender = rs.getString("gender");
				String passwd = rs.getString("password");
				String type = rs.getString("type");
				
				out.println("<tr><td>"+regno+"</td>"
						+"<td>"+firstname+"</td><td>"+lastname+"</td><td>"+gender+"</td><td>"+passwd+"</td><td>"+type+"</td></tr>");
				
				session.setAttribute("name", firstname);
				session.setAttribute("type1", type);
				
				

				out.println("<a href=viewAllStudents1> view all students</a>");
			}
			else {
				/*HttpSession session=req.getSession();
				session.setAttribute("name", userId);*/
				++count;
				start=Instant.now();
//				session.setAttribute("time", count);
				
				
				out.println("<h2>login failed, invalid userID or Password</h2>");
		
			}
			out.print("</table>");
			out.print("</body>");
			out.print("</html>");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) {
				rs.close();}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			try {
				if(stmt!=null) {
				stmt.close();}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			try {
				if(con!=null) {
				con.close();}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		}else {
			stop=Instant.now();
			timediff=Duration.between(start, stop).toMillis();
		
			if(timediff<100000) {
				out.print("<h3>account locked</h3>");	
			}else {
				count=0;
				out.println("<h3>your account is un-locked go back and login</h3>");
			}
		}
	}
}
