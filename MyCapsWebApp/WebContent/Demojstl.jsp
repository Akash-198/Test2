<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@taglib uri="http://java.sun.com/jstl/core" prefix="c" %>  
    <html>  
    <head>  
    <title>Tag Example</title>  
    </head>  
    <body>  
  	<c:out value="${'<tag>,&'}"/>
  	
    </body>  
    </html>  