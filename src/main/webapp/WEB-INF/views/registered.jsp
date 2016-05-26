<%-- 
    Document   : registered
    Created on : May 25, 2016, 10:07:24 AM
    Author     : nikesh.maharjan
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration</title>
    </head>
    <body>
        <h1>Successful registration</h1>
        <h2>Login Info:</h2>
        Username: <c:out value="${loginInfo.username}" /><br/>
        Password: <c:out value="${loginInfo.password}" /><br/>
        <div>
            <a href="<c:url value="/" />">Home</a>
        </div>
    </body>
</html>
