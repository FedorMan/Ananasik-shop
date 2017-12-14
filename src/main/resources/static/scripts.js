var app = angular.module('myApp', []);
app.controller('Controller', function ($scope, $http) {
    $scope.saveProduct = function () {
        $scope.master = angular.copy($scope.product);
        $http.post("/controller/product/save", $scope.master).success(function (master, status) {
            $scope.hello = $scope.master;
            $scope.product = {};
            $scope.loadProducts();
        });
    };

    $scope.loadProducts = function () {
        $http.get("/controller/product/all").then(function (response) {
            $scope.products = response.data;
        });
    };

    $scope.loadProduct = function (x,rowIndex) {
        $scope.productInFocus = x;
        $scope.selectedRow = rowIndex;
    };

    $scope.deleteProduct = function () {
        $http.get("/controller/product/delete?id=" + $scope.productInFocus.id).then(function (response) {
            $scope.loadProducts();
        });
    };

    $scope.saveSeller = function () {
        $scope.seller.birthday = $scope.birthday.value;
        $scope.seller.startworkdate = $scope.startDate.value;
        $scope.master = angular.copy($scope.seller);
        $http.post("/controller/seller/save", $scope.master).success(function (master, status) {
            $scope.hello = $scope.master;
            $scope.seller = {};
            $scope.loadSellers();
        });
    };

    $scope.loadSellers = function () {
        $http.get("/controller/seller/all").then(function (response) {
            $scope.sellers = response.data;
        });
    };

    $scope.loadSeller = function (x,rowIndex) {
        $scope.sellerInFocus = x;
        $scope.selectedRow = rowIndex;
    };

    $scope.deleteSeller = function () {
        $http.get("/controller/seller/delete?id=" + $scope.sellerInFocus.id).then(function (response) {
            $scope.loadSellers();
        });
    };

    $scope.viewSellers = function () {
        $scope.productView = false;
        $scope.sellerView = true;
        $scope.selectedRow = null;
    };
    $scope.viewProducts = function () {
        $scope.productView = true;
        $scope.sellerView = false;
        $scope.selectedRow = null;
    };


    $scope.loadProducts();
    $scope.loadSellers();

    $scope.productView = true;
    $scope.sellerView = false;
    $scope.selectedRow = null;

});
