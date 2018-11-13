package com.caps;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Serv2 extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out=resp.getWriter();
		
		ServletConfig config=getServletConfig();
		
		/*ServletContext ctx=config.getServletContext();
		 * 
		 * we can create an context object by using the config object
		 */
		
		String password=config.getInitParameter("password");
		out.println(password);
	}
}
