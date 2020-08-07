var app = angular.module('app', []);

app.controller('c1', function ($scope) {
    $scope.name = 'Bob';

})

app.directive('fooBar', function () {
    return {
        restrict: 'E',
        transclude: true,
        template: `one <div ng-transclude></div>`,
        link: function (scope, element, attrs, ctrl, transclude) {
            console.log('fooBarM');

            //в виде функции
            transclude(scope, function(clone, scope) {
                console.log('!', clone, scope);
                element.append(clone); // добовляем в конец клон
            });

        }
    }
});