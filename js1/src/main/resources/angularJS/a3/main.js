var app = angular.module('app', []);

app.controller('firstCtrl', function($scope, myFactory) { // прокидываем фабрику
    console.log('firstCtrl');
    $scope.myFactory = myFactory; // инжектив в шаблон
    $scope.hello = 'hello world';
});

app.controller('secondCtrl', function($scope, myFactory) {
    console.log('secondCtrl');
    $scope.myFactory = myFactory;
    $scope.hello = 'hello world';
});

app.factory('myFactory', function() {//state
    return {
        hello: 'hello world'
    };
});