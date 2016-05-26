<%-- 
    Document   : listAlbums
    Created on : May 25, 2016, 11:00:04 AM
    Author     : nikesh.maharjan
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">        
        <link rel="stylesheet" href="<c:url value="/res/css/styles.css" />" />

        <title>Albums</title>
    </head>
    <body>
        <h1>List of Albums</h1>

        <span class="error"><c:out value="${errorMessage}" /></span>

        <table border="1" style="width:100%">
            <thead>
                <tr>
                    <th>Title</th>
                    <th>Band</th>
                    <th>Year</th>
                    <th>No of Tracks</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${albumList}" var="album">
                    <c:set var="albumId" value="${album.id}" />
                    <tr>
                        <td><c:out value="${album.albumTitle}" /></td>
                        <td><c:out value="${album.band}" /></td>
                        <td><c:out value="${album.year}" /></td>
                        <td><c:out value="${album.noOfTracks}" /></td>
                        <td>
                            <a href="<c:url value='/albums/update/${albumId}' />">Update</a>
                            |
                            <a href="<c:url value='/albums/delete/${albumId}' />">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
                <c:if test="${albumList eq null}">
                    <tr>
                        <td colspan="5" style='text-align: center;font-weight:bold;font-style: italic'>No albums to show.</td>
                    </tr>
                </c:if>
            </tbody>
        </table>
        <a href="<c:url value='/albums/add' />">Add more</a>
    </body>
</html>
