var app = angular.module('app', []);



app.controller('b', function($scope) {
    $scope.name = 'Harry';
    console.log($scope)
})


app.directive('book', function () {
    return {
        scope: true, //наследуе скоп родителя
        template: "<div>My name is {{name}} <input type='text' ng-model='name'></div>",
        link:  function (scope, element, attrs) {
            console.log('scope', scope);

        }

    };
});