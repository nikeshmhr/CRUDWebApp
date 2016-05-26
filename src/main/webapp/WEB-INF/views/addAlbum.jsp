<%-- 
    Document   : addAlbum
    Created on : May 25, 2016, 11:28:10 AM
    Author     : nikesh.maharjan
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="<c:url value="/res/css/styles.css" />" />

        <title>Album: Add</title>
    </head>
    <body>
        <h1>Add new album</h1>
        <form method="POST">
            <div>
                <input type="text" name="albumTitle" placeholder="Album Title" required />
            </div>

            <div>
                <input type="text" name="band" placeholder="Band Name" required />
            </div>

            <div>
                <input type="number" name="year" value="1999" placeholder="Release Year" maxlength="4" required />
            </div>

            <div>
                <input type="number" name="noOfTracks" placeholder="No of Tracks" min="1" maxlength="2" required />
            </div>

            <div>
                <input type="submit" name="submit" value="Add" />
            </div>
        </form>
        <span class="error"><c:out value="${errorMessage}" /></span>
    </body>
</html>
