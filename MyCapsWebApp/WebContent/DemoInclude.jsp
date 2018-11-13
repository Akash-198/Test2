<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Include</title>
</head>
<body>

<jsp:include page="/date?data=helloworld"/>

<%--  we can also do the above thing in a diffrent way
	<jsp:include page="/date">
		<jsp:param value="helloworld" name="data">
	</jsp:include>	
 --%>

</body>
</html>