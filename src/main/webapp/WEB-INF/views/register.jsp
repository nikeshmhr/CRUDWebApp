<%-- 
    Document   : register
    Created on : May 25, 2016, 9:47:33 AM
    Author     : nikesh.maharjan
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
        <link rel="stylesheet" href="<c:url value="/res/css/styles.css" />" />
    </head>
    <body>
        <h1>Register</h1>
        <form action="<c:url value='/register' />" method="POST">
            <div>
                <label for="username">Username:</label>
                <input type="text" name="username" required="required" />
            </div>
            <div>
                <label for="password">Password:</label>
                <input type="password" name="password" required="required" />
            </div>
            <div>
                <input type="submit" name="submit" value="Register" />
            </div>
        </form>
        <span class="error"><c:out value="${errorMessage}" /></span>
    </body>
</html>
