/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


app.controller('ListAlbumsController', ['$scope', 'AlbumService', function ($scope, AlbumService) {
        $scope.addMore = false;

        $scope.albumsList = {};

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

    }]);