package com.caps;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.caps.beans.Cat;
import com.caps.beans.Dog;

@WebServlet("/serv3")
public class Serv3 extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Dog d=new Dog();
		d.setName("Bingo");
		d.setColor("white");
		d.setBreed("Pomerian");
		req.setAttribute("dog", d);
		
		Cat c=new Cat();
		c.setColor("white");
		c.setGender("male");
		c.setName("Rose");
		ServletContext ctx=getServletContext();
		ctx.setAttribute("cat", c);
		
		RequestDispatcher dispatcher=req.getRequestDispatcher("/serv4");
		dispatcher.forward(req, resp);
		
	}

}
