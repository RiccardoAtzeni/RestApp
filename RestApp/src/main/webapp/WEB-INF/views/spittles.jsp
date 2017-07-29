<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page isELIgnored="false" %>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Spittles</title>
	<link rel="stylesheet"
		  type="text/css"
		  href="<c:url value="/resources/style.css" />" >
		  
</head>

<body>
	<h1>Recent Spittles</h1>
	
	<c:forEach items="${spittleList}" var="spittle">
		<li id="spittle_<c:out value="spittle.id"/>" >
			<div class="spittleMessage" style="color:orange">
				<c:out value="${spittle.message}" />
			</div>
			<div>
				<span class="spittleTime">
					<b>Sent:</b> <c:out value="${spittle.time}" />
				</span>
				<span class="spittleLocation">
					(<b>Latitude :</b> <c:out value="${spittle.latitude}" />,
					<b>Longitude :</b> <c:out value="${spittle.longitude}" />)
					<br/><br/>
				</span>
			</div>
	</c:forEach>
	
</body>
</html>