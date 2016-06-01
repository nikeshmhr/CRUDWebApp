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
                                    console.error('Error while fetching users');
                                    return $q.reject(errResponse);
                                }
                        )
            }
        };
    }]);
