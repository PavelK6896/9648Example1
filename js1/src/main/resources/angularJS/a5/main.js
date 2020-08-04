var app = angular.module('app', []);

app.controller('c1', function($scope) {
    $scope.showBook = function () {
        console.log('This is c1 book');
    };
});
app.controller('c2', function($scope) {
    $scope.showBook = function () {
        console.log('This is c2 book');
    };
});
app.controller('c3', function($scope) {
    $scope.showBook = function () { // переопределение родителя
        console.log('This is c3 book');
    };
});

