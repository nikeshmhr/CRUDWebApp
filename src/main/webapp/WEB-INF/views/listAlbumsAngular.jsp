<%-- 
    Document   : listAlbumsAngular
    Created on : Jun 1, 2016, 11:05:56 AM
    Author     : nikesh.maharjan
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List of Albums with Angular</title>

        <link rel="stylesheet" href="<c:url value='/res/css/styles.css' />" />
        <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>

        <script type="text/javascript" src="<c:url value='/res/js/app.js' />"></script>
        <script type="text/javascript" src="<c:url value='/res/js/AlbumService.js' />"></script>
        <script type="text/javascript" src="<c:url value='/res/js/ListAlbumsController.js' />"></script>
    </head>
    <body ng-app="crudApp" ng-controller="ListAlbumsController">
        {{ album}}
        <h1>Add Album</h1>
        <form ng-submit="addAlbum()">
            <div>
                <input type="text" ng-model="album.albumTitle" required="required" placeholder="Title" />
            </div>
            <div>
                <input type="text" ng-model="album.band" required="required" placeholder="Band" />
            </div>
            <div>
                <input type="number" ng-model="album.year" required="required" placeholder="Year" />
            </div>
            <div>
                <input type="number" ng-model="album.noOfTracks" required="required" placeholder="No. of Tracks" />
            </div>
            <input type="submit" value="Add" />
        </form>

        <h1>List of Albums</h1>

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
                <tr ng-repeat="album in albumsList">
                    <td>{{ album.albumTitle}}</td>
                    <td>{{ album.band}}</td>
                    <td>{{ album.year}}</td>
                    <td>{{ album.noOfTracks}}</td>
                    <td>
                        <button type="button" ng-click="deleteAlbum(album.id)">Delete</button>
                    </td>
                </tr>
            </tbody>
        </table>
    </body>
</html>
