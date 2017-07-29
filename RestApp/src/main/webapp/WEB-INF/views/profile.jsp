<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Spittle</title>
	<link rel="stylesheet"
		  type="text/css"
		  href="<c:url value="/resources/style.css" />" >
		  
</head>

<body>
	<h1>Your Profile</h1>
	<c:out value="${spitter.username}" /><br/>
	<c:out value="${spitter.firstName}" />
	<c:out value="${spitter.lastName}" />
	
</body>
</html>