package com.jjsspp;

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

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/loginServ3")
public class LoginServlet extends HttpServlet
{
	Instant Start;
	Instant Stop;
	long timediff=0l;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String userId=req.getParameter("userid");
		String password=req.getParameter("password");
		PrintWriter out=resp.getWriter();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		UserAutherization user=UserAutherization.getUserAuth(userId);
		
		if(user.getAttempts()<3) {
		
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
				out.println("<h2>login failed, invalid userID or Password</h2>");
				user.setAttempts();
				Start=Instant.now();
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if(stmt!=null) {
				stmt.close();}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if(con!=null) {
				con.close();}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		}else {
			Stop=Instant.now();
			timediff=Duration.between(Start, Stop).toMillis();
			if(timediff<100000) {
			out.println("<h2>account is locked, consult Admin!</h2>");
			}else {
				user.resetAttempts();
				out.println("<h2>Your account is unlocked, go back and login<h2>");
			}
		}
		
	}
}
