<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Date</title>
</head>
<body>
<%!
int i=10;
public void hello(){
	System.out.println("hello JSP");
	System.out.println(i);
}
%>
<%out.print("hello"); %>
<%="hello" %>
<h1>The current date is <%=new Date()%></h1>
</body>
</html>