var app = angular.module('myApp', []);
app.controller('Controller', function ($scope, $http) {
    $scope.saveProduct = function () {
        $scope.master = angular.copy($scope.product);
        $http.post("/saveProduct", $scope.master).success(function (master, status) {
            $scope.hello = $scope.master;
            $scope.product = {};
            $scope.loadProducts();
        });
    };

    $scope.loadProducts = function () {
        $http.get("/getProducts").then(function (response) {
            $scope.products = response.data;
        });
    };

    $scope.loadProduct = function (x) {
        $scope.productInFocus = x;
    };

    $scope.deleteProduct = function () {
        $http.get("/deleteProduct?id=" + $scope.productInFocus.id).then(function (response) {
            $scope.loadProducts();
        });
    };

    $scope.loadProducts();
});

