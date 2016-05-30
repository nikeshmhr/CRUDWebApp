/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


app.controller('ListAlbumsController', function($scope){
    $scope.addMore = false;
    
    $scope.showAddMore = function(){
        $scope.addMore = true;
    };
    
});