package com.trail.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/urlrewrite")
public class UrlRewriting extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String url=req.getRequestURL().toString();
		
		HttpSession session = req.getSession();
		
		PrintWriter out=resp.getWriter();
		out.println("session ID"+session.getId());
		out.println(resp.encodeRedirectURL(url));
	}
}
