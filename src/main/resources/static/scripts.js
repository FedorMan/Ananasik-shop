var app = angular.module('myApp', []);
app.controller('Controller', function ($scope, $http) {
    $scope.saveProduct = function () {
        $scope.master = angular.copy($scope.product);
        $http.post("/saveProduct", $scope.master).success(function (master, status) {
            $scope.hello = $scope.master;
        });
    };
    $scope.product = {"name":"name","price":"1","unit":"unit"};
});