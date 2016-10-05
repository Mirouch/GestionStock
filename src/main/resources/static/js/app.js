var app = angular.module('app', ['ngRoute', 'controllers']);

app.config(function ($routeProvider) {
    $routeProvider
        .when('/', {
            templateUrl: '/views/home.html',
        })

        .when('/products', {
            templateUrl: '/views/products.html',
            controller: 'productsCtrl'
        })
        .when('/product/:id', {
            templateUrl: '/views/productDetail.html',
            controller: 'productDetailCtrl'
        })



       /*
        .when('/products', {
            templateUrl: '/views/addProduct.html',
            controller: 'addProductCtrl'

        })
        */


        .otherwise(
            {redirectTo: '/'}
        );
});

