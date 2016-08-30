var app = angular.module('app', ['ngRoute', 'ngResource']);
app.config(function ($routeProvider) {
    $routeProvider
        .when('/products', {
            templateUrl: '/views/products.html',
            controller: 'productsController'
        })
        .when('/product/:id', {
            templateUrl: '/views/product.html',
            controller: 'productController'
        })
        .otherwise(
            {redirectTo: '/'}
        );
});

