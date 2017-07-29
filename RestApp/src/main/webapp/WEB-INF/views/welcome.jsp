<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Spittr</title>
	<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/static/style.css' />" rel="stylesheet"></link>
</head>
<body background="<c:url value='/static/images/spittr_logo.png' /> ">
	<div class="form-container">
	<h1><s:message code="spittr.welcome" /></h1><br/>
	
	<s:url value="/spittle" var="spittlesUrl">
		<!--<s:param name="max" value="60" />-->
		<s:param name="count" value="20" />
	</s:url>
	
	<h2>Find out last recent 
	<a href="${spittlesUrl}">spittles</a>
	</h2> 
	
	<s:url value="/spitter/register" var="registerUrl" />
	<a href="${registerUrl}">Register</a>	
	
	Click on below links to upload a single file or multiple ones. <br/><br/>
	
	<a href="<c:url value='/singleUpload' />">Single File Upload</a> OR <a href="<c:url value='/multiUpload' />">Multi File Upload</a>
	</div>

</body>
</html>