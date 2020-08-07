var app = angular.module('app', ['ngRoute']);

app.config(function ($routeProvider) {

    console.log("ssss")
    $routeProvider
        .when('/', {
            templateUrl: 'page/home.html',
            controller: 'homeCtrl'
        })
        .when('/product', {
            template: 'page/product.html',
            controller: 'productCtrl'
        })
});


app.controller('productCtrl', function ($scope) {
    console.log('productCtrl');
    $scope.model = {
        message: 'Product controller'
    }
});


app.controller('homeCtrl', function ($scope) {
    console.log('HomeCtrl');
    $scope.model = {
        message: 'Home controller'
    }
});