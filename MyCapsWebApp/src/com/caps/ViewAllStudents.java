package com.caps;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/viewAllStudents")
public class ViewAllStudents extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		PrintWriter out=resp.getWriter();
		HttpSession session=req.getSession(false);
		if(session!=null) {
		
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
			/*
			 * 3. Issue the SQL query via connection
			 */
			String sql = "select * from students_info";

			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			/*
			 * 4. Process the results
			 */
			out.print("<html>");
			out.print("<body>");
			out.print("<table border='1px' cellpadding='5px' cellspacing='0px' bordercolor='black'>");
			out.print("<tr><th>SID</th><th>FNAME</th><th>LNAME</th><th>GENDER</th><th>PASSWORD</th><th>TYPE</th>");
			while(rs.next()){
				int regno = rs.getInt("sid");
				String firstname = rs.getString("firstname");
				String lastname = rs.getString("lastname");
				String gender = rs.getString("gender");
				String passwd = rs.getString("password");
				String type = rs.getString("type");

				out.println("<tr><td>"+regno+"</td>"
						+"<td>"+firstname+"</td><td>"+lastname+"</td><td>"+gender+"</td><td>"+passwd+"</td><td>"+type+"</td></tr>");
				
			}
			out.print("</table>");
			out.print("</body>");
			out.print("</html>");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
		}else {
			out.println("login again");
		}
	}
}
