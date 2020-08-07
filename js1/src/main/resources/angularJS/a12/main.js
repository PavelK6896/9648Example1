var app = angular.module('app', []);


app.directive('fooBar', function () {
    return {
        restrict: 'E', //елемент для дерективы
        transclude: true,
        templateUrl: `b.html`,
        link: function (scope, element, attrs, ctrl, transclude) {
            console.log('directive');
        }
    }
});