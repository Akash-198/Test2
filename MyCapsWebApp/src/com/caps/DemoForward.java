package com.caps;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/forward1")
public class DemoForward extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("runnig forward1 ");
		
		PrintWriter out=resp.getWriter();
		out.println("<h1>running forward1</h1>");
		
		RequestDispatcher dispatcher= req.getRequestDispatcher("/froward2");
		dispatcher.include(req, resp);
		
		dispatcher=req.getRequestDispatcher("/date");
		dispatcher.include(req, resp);
	}
}
