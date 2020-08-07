var app = angular.module('app', []);


app.run(function ($templateCache) { // хук начало
    $templateCache.put('c.html',
        `<div ng-repeat="b in bb">{{b}}</div>`
    )
})

app.directive('fooBar', function ($templateCache) {
    return {
        restrict: 'E', //елемент для дерективы
        transclude: true,
        templateUrl: `c.html`, // берет из кеша или ажакс запрос
        link: function (scope, element, attrs, ctrl, transclude) {

            scope.bb = [{id: 1}, {id: 2}]
            console.log("$templateCache", $templateCache)
            console.log("$templateCache", $templateCache.info())
        }
    }
});