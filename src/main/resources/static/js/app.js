var app = angular.module('app', ['ngRoute', 'ngResource']);
app.config(function ($routeProvider) {
    $routeProvider
        .when('/products', {
            templateUrl: '/views/products.html',
            controller: 'productsController'
        })
        .otherwise(
            {redirectTo: '/'}
        );
});

