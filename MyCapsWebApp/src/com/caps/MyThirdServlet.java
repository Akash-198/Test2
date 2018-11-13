package com.caps;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class MyThirdServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String lang[]=req.getParameterValues("lang");
		System.out.println("method->"+req.getMethod());
		System.out.println("content lenght ->"+ req.getContentLength());
		System.out.println("local host name->"+ req.getLocalName());
		System.out.println("local port"+req.getLocalPort());
		System.out.println("local address"+req.getLocalAddr());
		
		PrintWriter out= resp.getWriter();
		out.println(Arrays.toString(lang));
	}
}
