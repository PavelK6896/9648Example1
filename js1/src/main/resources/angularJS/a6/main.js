var app = angular.module('app', []);

app.controller('c1', function($scope) {
    this.m3 = "this.m1"

    $scope.showBook = function () {
        console.log('$scope $scope $scopeThis is c1 book');
    };
    this.showBook = function () {
        console.log('This is c1 book');
    };

});
app.controller('c2', function($scope) {
    this.m3 = "this.m2"
    $scope.showBook = function () {
        console.log('This is c2 book');
    };
});
app.controller('c3', function($scope) {
    this.m3 = "this.m3"
    $scope.m3 = "m3"
    $scope.showBook = function () { // переопределение родителя
        console.log('This is c3 book');
    };
});

