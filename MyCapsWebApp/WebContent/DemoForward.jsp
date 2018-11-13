<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Forward</title>
</head>
<body>
<jsp:forward page="/date">
	<jsp:param value="java" name="data"/>
</jsp:forward>


<%-- or we can also do the above thing in this way
	<jsp:forward page="/date?data=java"/>
 --%>

</body>
</html>