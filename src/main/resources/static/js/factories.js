angular.module("app").factory("productsRetriever", function ($http, $q) {
    
    function getAllProducts() {
       return $http({
            method: 'GET',
            headers: { 'Content-Type': 'application/json; charset=UTF-8'},
            data: '',
            url: 'http://localhost:8080/products'
        }).then(function(data) {
            console.log("successssss !!", data);
            return data;
        }).catch(function(response){
            $q.reject("Sorry, we couldn't retrieve data", response.status);
        });
        
    }
    

    return{
        getAllProducts : getAllProducts
    }
});
