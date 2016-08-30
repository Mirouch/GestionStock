app.controller('productsController', function($scope, $http) {
    $scope.headingTitle = "p List";

    $http({
        method: 'GET',
        //withCredentials:true,
        headers: { 'Content-Type': 'application/json; charset=UTF-8'},
        data: '',
        url: 'http://localhost:8080/products/13'
    }).
    success(function(data) {
        $scope.product = data;
    });

    /*
    $http.get('http://localhost:8080/products/13').
    success(function(data) {
        $scope.product = data;
    });
    */
});

