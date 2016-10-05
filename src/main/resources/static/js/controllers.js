 angular.module('controllers', [])

     .controller('productsCtrl', ['$scope','$http' ,'$log', function($scope, $http, $log)  {
         $scope.title = "Stock";

         $scope.formToggle = function () {
             $('#productForm').slideToggle();
         }
         $http.get('http://localhost:8080/products')
             .success(function (data) {
                 $scope.products = data;
             })
             .error(function (err) {
                 $log.error(err);
             })
         $scope.pushData = function ($params) {
             $http.post('http://localhost:8080/products', {'nom': $params.nom, 'designation': $params.designation})
                  .success(function (data) {
                      $scope.products = data;
                      $log.info(data);
                  })
                  .error(function (err) {
                      $log.error(err);
                  })
         }
     }])

