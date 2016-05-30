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
        <link rel="stylesheet" href="<c:url value='/res/css/styles.css' />" />
        <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>

        <script type="text/javascript" src="<c:url value='/res/js/app.js' />"></script>
        <script type="text/javascript" src="<c:url value='/res/js/ListAlbumsController.js' />"></script>

        <title>Albums</title>
    </head>
    <body ng-app="crudApp" ng-controller="ListAlbumsController">
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
        <button type="button" ng-click="showAddMore()">Add more</button>

        <div ng-show="addMore">
            <h1>Add new album</h1>
            <form method="POST" name="addAlbum" action="<c:url value='/albums/add' />">
                <div>
                    <input type="text" name="albumTitle" ng-model="albumTitle" placeholder="Album Title" required />
                    <span class="error" ng-show="addAlbum.albumTitle.$touched && addAlbum.albumTitle.$invalid">Album title is required.</span>
                </div>

                <div>
                    <input type="text" name="band" ng-model="band" placeholder="Band Name" required />
                    <span class="error" ng-show="addAlbum.band.$touched && addAlbum.band.$invalid">Band name required.</span>
                </div>

                <div>
                    <input type="number" name="year" ng-model="year" placeholder="Release Year" minlength="4" maxlength="4" required />
                    <span class="error" ng-show="addAlbum.year.$touched && addAlbum.year.$invalid">Invalid date.</span>
                </div>

                <div>
                    <input type="number" name="noOfTracks" ng-model="noOfTracks" placeholder="No of Tracks" min="1" maxlength="2" required />
                    <span class="error" ng-show="addAlbum.noOfTracks.$touched && addAlbum.noOfTracks.$invalid">No. of tracks is required.</span>
                </div>

                <div>
                    <input type="submit" name="submit" value="Add" 
                           ng-disabled="addAlbum.albumTitle.$invalid || addAlbum.band.$invalid || addAlbum.year.$invalid" />
                </div>
            </form>
            <span class="error"><c:out value="${errorMessage}" /></span>
        </div>
    </body>
</html>
