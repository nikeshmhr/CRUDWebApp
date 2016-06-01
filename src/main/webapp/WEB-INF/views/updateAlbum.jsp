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

        <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>

        <script type="text/javascript" src="<c:url value='/res/js/app.js' />"></script>
        <script type="text/javascript" src="<c:url value='/res/js/ListAlbumsController.js' />"></script>
        <title>Album: Update</title>
    </head>
    <body>
        <h1>Update Album</h1>

        <form method="POST" name="updateAlbum">
            <input type="hidden" value="<c:out value='${album.id}' />" name="id" />
            <div>
                <input type="text" ng-model="albumTitle" name="albumTitle" value="<c:out value='${album.albumTitle}' />" placeholder="Album Title" required />
                <span class="error" ng-show="updateAlbum.albumTitle.$touched && updateAlbum.albumTitle.$invalid">Album title is required.</span>
            </div>

            <div>
                <input type="text" name="band" ng-model="band" value="<c:out value='${album.band}' />" placeholder="Band Name" required />
                <span class="error" ng-show="updateAlbum.band.$touched && updateAlbum.band.$invalid">Band name required.</span>
            </div>

            <div>
                <input type="number" name="year"  ng-model="year" value="<c:out value='${album.year}' />" placeholder="Release Year" maxlength="4"  required />
                <span class="error" ng-show="updateAlbum.year.$touched && updateAlbum.year.$invalid">Invalid date.</span>
            </div>

            <div>
                <input type="number" name="noOfTracks" ng-model="noOfTracks" value="<c:out value='${album.noOfTracks}' />" placeholder="No of Tracks" min="1" maxlength="2" required />
                <span class="error" ng-show="updateAlbum.noOfTracks.$touched && updateAlbum.noOfTracks.$invalid">No. of tracks is required.</span>
            </div>

            <div>
                <input type="submit" name="submit" value="Update"
                       ng-disabled="updateAlbum.albumTitle.$invalid || updateAlbum.band.$invalid || updateAlbum.year.$invalid" />
            </div>
        </form>
        <span class="error"><c:out value="${errorMessage}" /></span>
    </body>
</html>
