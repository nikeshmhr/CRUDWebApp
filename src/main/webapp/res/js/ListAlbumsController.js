/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


app.controller('ListAlbumsController', ['$scope', 'AlbumService', function ($scope, AlbumService) {
        $scope.addMore = false;

        $scope.album = {id: '', albumTitle: '', band: '', year: '', noOfTracks: ''};

        var jsonAlbumData = "";

        $scope.albumsList = [];

        $scope.showAddMore = function () {
            $scope.addMore = true;
        };

        $scope.fetchAllAlbums = function () {
            AlbumService.fetchAllAlbums()
                    .then(
                            function (d) {
                                $scope.albumsList = d;
                            },
                            function (errResponse) {
                                console.error('Error while fetching');
                            }
                    );
        };

        $scope.fetchAllAlbums();

        $scope.submitAdd = function () {
            jsonAlbumData = $scope.album;
        }

        $scope.addAlbum = function () {
            AlbumService.createAlbum(jsonAlbumData)
                    .then(
                            $scope.fetchAllAlbums,
                            function (error) {
                                console.error("error while adding");
                            }
                    );
        };

        $scope.deleteAlbum = function (id) {
            AlbumService.deleteAlbum(id)
                    .then(
                            $scope.fetchAllAlbums,
                            function (error) {
                                console.error("error while deleting");
                            }
                    );
        };

    }]);