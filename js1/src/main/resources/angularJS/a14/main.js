var app = angular.module('app', []);



app.controller('mainCtrl', function($scope) {

    console.log("$scope", $scope)
    $scope.post = [
        {n: "1"},{n: "2"}
    ]
    $scope.hello = "Hello";

    $scope.getPost = () =>{
        return $scope.post
    }

})


app. directive('post', function () { // наследует скоп контролера
    return {
        scope: false, // поумолчанию
        template: `<div ng-repeat="p in getPost()"> {{p}} </div>`,
        link:  function (scope, element, attrs) {
            console.log('scope', scope);
            scope.hello = " hi"
        }

    };
});