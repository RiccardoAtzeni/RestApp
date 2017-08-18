<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>Login</title>
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/static/style.css' />" rel="stylesheet"></link>
</head>
<body>
    <div id="login-box">
        <h2>Hi Spitter! Please log in to access your page</h2>

        <c:if test="${param.error != null}">
            <div class="has-error">
                <br/>
                Invalid username and password
                <c:out value="${param.error}" /><br/>
                <br/>
            </div>
        </c:if>
        <c:if test="${param.logout != null}">
            <div class="glyphicon-log-out">You have been successfully logged out</div>
        </c:if>
        <c:url var="loginUrl" value="/login"/>
            <form name="loginForm" method="post" action="${loginUrl}">
                <label for="username">Username</label>
                <input type="text" id="username" name="username"/>
                <label for="password">Password</label>
                <input type="password" id="password" name="password"/>

                 <div class="form-actions">
                     <button type="submit">Log in</button>
                </div>

                 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            </form>
    </div>
</body>
</html>
