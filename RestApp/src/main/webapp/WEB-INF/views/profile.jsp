<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page isELIgnored="false" %>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Spittle</title>
	<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/static/style.css' />" rel="stylesheet"></link>
		  
</head>

<body>
  <div class="form-container">
	<h1>Hello&nbsp;<c:out value="${spitter.firstName}" />&nbsp;<c:out value="${spitter.lastName}" />!</h1>
	
	<h6>Logged as <c:out value="${spitter.username}" /><br/></h6>
	</div>

	
</body>
</html>