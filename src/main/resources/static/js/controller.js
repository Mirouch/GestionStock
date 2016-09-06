app.controller('productsController', function($scope, $http, productsRetriever) {

    productsRetriever
        .getAllProducts()
        .then(function(data) {
            $scope.products = data;
        })
        .catch(function(message) {
            console.log(message);
        })


    $scope.headingTitle = "Product List";

    $http({
        method: 'GET',
        headers: { 'Content-Type': 'application/json; charset=UTF-8'},
        data: '',
        url: 'http://localhost:8080/products'
    }).
    success(function(data) {
        $scope.products = data;
    });


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