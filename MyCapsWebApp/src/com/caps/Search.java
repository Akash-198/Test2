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
@WebServlet("/search")
public class Search extends HttpServlet	
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String input=req.getParameter("search");
		
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
			String sql = "select * from students_info where firstname=?";

			stmt = con.prepareStatement(sql);
			stmt.setString(1, input);
			rs = stmt.executeQuery();

			/*
			 * 4. Process the results
			 */
			PrintWriter out=resp.getWriter();
			out.print("<html>");
			out.print("<body margin-top='50px'>");
			out.print("<table border='1px' cellpadding='5px' cellspacing='0px' bordercolor='black' align='center'>");
			out.print("<tr><th>SID</th><th>FNAME</th><th>LNAME</th><th>GENDER</th><th>PASSWORD</th><th>TYPE</th>");

			if(rs.next()){
				int regno = rs.getInt("sid");
				String firstname = rs.getString("firstname");
				String lastname = rs.getString("lastname");
				String gender = rs.getString("gender");
				String passwd = rs.getString("password");
				String type = rs.getString("type");

				out.println("<tr><td>"+regno+"</td>"
						+"<td>"+firstname+"</td><td>"+lastname+"</td><td>"+gender+"</td><td>"+passwd+"</td><td>"+type+"</td></tr>");
			}
			else {
				out.println("No data found");
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
	
	}
}
