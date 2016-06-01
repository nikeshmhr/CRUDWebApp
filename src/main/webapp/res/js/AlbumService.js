/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

app.factory('AlbumService', ['$http', '$q', function ($http, $q) {
        return {
            fetchAllAlbums: function () {
                return $http.get('http://localhost:9090/CRUDWebApp/albums')
                        .then(
                                function (response) {
                                    return response.data;
                                },
                                function (errResponse) {
                                    console.error('Error while fetching album');
                                    return $q.reject(errResponse);
                                }
                        );
            },
            createAlbum: function (album) {
                return $http.post('http://localhost:9090/CRUDWebApp/albums/add', album)
                        .then(
                                function (response) {
                                    return response.data;
                                },
                                function (errResponse) {
                                    console.error("Error while creating album");
                                    return $q.reject(errResponse);

                                }
                        );
            },
            deleteAlbum: function (id) {
                return $http.delete('http://localhost:9090/CRUDWebApp/albums/delete/' + id)
                        .then(
                                function (response) {
                                    return response.data;
                                },
                                function (err) {
                                    console.error("Error while deleting album");
                                    return $q.reject(err);
                                }
                        );
            }
        };
    }]);
