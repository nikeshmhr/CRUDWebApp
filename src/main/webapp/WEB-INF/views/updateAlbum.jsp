<%-- 
    Document   : updateAlbum
    Created on : May 25, 2016, 12:43:34 PM
    Author     : nikesh.maharjan
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="<c:url value="/res/css/styles.css" />" />
        <title>Album: Update</title>
    </head>
    <body>
        <h1>Update Album</h1>

        <form method="POST">
            <input type="hidden" value="<c:out value='${album.id}' />" name="id" />
            <div>
                <input type="text" name="albumTitle" value="<c:out value='${album.albumTitle}' />" placeholder="Album Title" required />
            </div>

            <div>
                <input type="text" name="band" value="<c:out value='${album.band}' />" placeholder="Band Name" required />
            </div>

            <div>
                <input type="number" name="year" value="<c:out value='${album.year}' />" placeholder="Release Year" maxlength="4"  required />
            </div>

            <div>
                <input type="number" name="noOfTracks" value="<c:out value='${album.noOfTracks}' />" placeholder="No of Tracks" min="1" maxlength="2" required />
            </div>

            <div>
                <input type="submit" name="submit" value="Update" />
            </div>
        </form>
        <span class="error"><c:out value="${errorMessage}" /></span>
    </body>
</html>
