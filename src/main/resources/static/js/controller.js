app.controller('productsController', function($scope, $http) {
    $scope.headingTitle = "Product List";

    $http.get('http://localhost:8080/products').

    success(function (returnedData) {

        $scope.products = returnedData;

    }).
    error(function (returnedData) {

        alert("!hello")

    });


    /* $http({
        method: 'GET',
        headers: { 'Content-Type': 'application/json; charset=UTF-8'},
        data: '',
        url: 'http://localhost:8080/products'
    })


        .success(function(data) {
            $scope.products = data;
        })

        .error(function(data) {
           alert("!hello")
        })
*/




});


app.controller('productController', function($scope, $http, $routeParams) {
    $scope.headingTitle = "Product List";
    $http({
        method: 'GET',
        headers: {'Content-Type': 'application/json; charset=UTF-8'},
        data: '',
        url: 'http://localhost:8080/products/'+$routeParams.id
    }).success(function (data) {
        $scope.product = data;
    });
});




app.controller('addProductController',function ($scope,productService) {
    $scope.addProduct = function ()
    {
        productService.addProductToDB($scope.product);
    }

}).factory("productService",['$http',function ($http) {
    var fac ={};
    fac.addProductToDB = function (product) {

        $http.post("/products",product).success(function (response) {
            alert(response.status);
        })
    }

    return fac;
    
}])









///////////// keep it
/*
app.controller('addProductController', function($scope, $http) {
    $scope.headingTitle = "Product List";

    $http({
        method: 'POST',
        headers: {'Content-Type': 'application/json; charset=UTF-8'},
        data: '',
        url: 'http://localhost:8080/products/'
    });
    $scope.addProduct=function() {
        $http.post("ProductController", {
            'nom': $scope.nom,
            'tag': $scope.tag,
            'dateEntree': $scope.dateEntree,
            'prixAchat': $scope.prixAchat
        })
            .success(function (data, status, headers, config) {
                console.log("data inserted successfully");
            });
    }

});

*/











  /*  $scope.addProduct=function() {
        $http.post("insert.php", {
            'nom': $scope.nom,
            'tag': $scope.tag,
            'dateEntree': $scope.dateEntree,
            'prixAchat': $scope.prixAchat
        })
            .success(function (data, status, headers, config) {
                console.log("data inserted successfully");
            });
    }
}); */

//add a new Product
/*app.controller('addProductController', function($scope, $http) {
    ;
    var urlBase = "";
    $scope.addProduct = function addProduct() {
        if ($scope.nom == "" || $scope.tag == "" || $scope.dateEntree == "" || $scope.prixAchat == "") {
            alert("Insufficient Data!");
        }
        else {
            $http.post(urlBase + '/products', {
                nom: $scope.nom,
                tag: $scope.tag,
                dateEntree: $scope.dateEntree,
                prixAchat: $scope.prixAchat
            }).success(function (data, status, headers) {
                alert("Product added");


            });
        }
    };
}
 */