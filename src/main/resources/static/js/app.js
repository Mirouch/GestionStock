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

        .when('/products', {
            templateUrl: '/views/addProduct.html',
            controller: 'addProductController'

        })

        .otherwise(
            {redirectTo: '/'}
        );
});

