<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv='refresh' content=1>
<meta charset="ISO-8859-1">
<title>Date page</title>
</head>
<body>
<h1>The Date is:<%=new Date() %></h1>
<jsp:include page="Footer.jsp"/>
</body>
</html>