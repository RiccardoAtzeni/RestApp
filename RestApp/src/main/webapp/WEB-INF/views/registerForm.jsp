<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ page session="false" %>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Register to Spittr</title>	
   <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/static/style.css' />" rel="stylesheet"></link>
		  
</head>

<body>
    <div class="form-container">
	<h1>Sign in</h1>
	
	<sf:form method="POST" commandName="spitter" enctype="multipart/form-data">	
		<sf:errors path="*" element="div" cssClass="errors" /><br/>
		
		<sf:label path="firstName" cssErrorClass="error">First name</sf:label>:
		<sf:input path="firstName" cssErrorClass="error" /><br/>
		<sf:label path="lastName" cssErrorClass="error">Last name</sf:label>:
		<sf:input path="lastName" cssErrorClass="error" /><br/>
		<sf:label path="email" cssErrorClass="error">Your Email</sf:label>:
		<sf:input path="email" cssErrorClass="error" /><br/>
		<sf:label path="username" cssErrorClass="error">Username</sf:label>:
		<sf:input path="username" cssErrorClass="error" /><br/>
		<sf:label path="password" cssErrorClass="error">Password</sf:label>:
		<sf:input path="password" type="password" cssErrorClass="error" /><br/><br/>
		
		<label>Profile Picture</label>
		<input name="profilePicture" type="file" accept="image/jpeg,image/png,image/gif"/><br/><br/>
		
		<input type="submit" value="Register" />
	</sf:form>	
	</div>
	
</body>
</html>