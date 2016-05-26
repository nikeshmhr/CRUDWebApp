<%-- 
    Document   : login
    Created on : May 24, 2016, 3:16:09 PM
    Author     : nikesh.maharjan
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link rel="stylesheet" href="<c:url value="/res/css/styles.css" />" />
    </head>
    <body>
        <h1>Login</h1>
        <form action="<c:url value='/login' />" method="POST">
            <div>
                <label for="username">Username:</label>
                <input type="text" name="username" required="required" />
            </div>
            <div>
                <label for="password">Password:</label>
                <input type="password" name="password" required="required" />
            </div>
            <div>
                <input type="submit" name="submit" value="Login" />
            </div>
        </form>
        <div><a href="<c:url value="/register" />">Register</a></div>
        <span class="error"><c:out value="${errorMessage}" /></span>
    </body>
</html>
