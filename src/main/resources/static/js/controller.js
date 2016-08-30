app.controller('productsController', function($scope, $http) {
    $scope.headingTitle = "p List";

    $http({
        method: 'GET',
        //withCredentials:true,
        headers: { 'Content-Type': 'application/json; charset=UTF-8'},
        data: '',
        url: 'http://localhost:8080/products'
    }).
    success(function(data) {
        $scope.products = data;
    });


});

app.controller('productController', function($scope, $http, $routeParams) {
    $scope.headingTitle = "p List";

    $http({
        method: 'GET',
        //withCredentials:true,
        headers: {'Content-Type': 'application/json; charset=UTF-8'},
        data: '',
        url: 'http://localhost:8080/products/'+$routeParams.id
    }).success(function (data) {
        $scope.product = data;
    });
});