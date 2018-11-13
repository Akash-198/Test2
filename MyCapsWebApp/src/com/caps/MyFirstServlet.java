package com.caps;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/date")
public class MyFirstServlet extends HttpServlet
{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out=resp.getWriter();
		out.println("<h1>The Date is:"+ new Date()+"</h1>");
		
		String data=req.getParameter("data");
		out.println("<h2>"+data+"</h2>");
		ServletContext ctx=getServletContext();
		out.println(ctx.getInitParameter("email"));
		
		/* String email=ctx.getInitParameter("email");
		 * out.println(email);
		 */
		
	}
}
