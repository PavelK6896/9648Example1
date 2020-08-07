var app = angular.module('app', ['ngRoute']);

app.config(function ($routeProvider) {
    $routeProvider
        .when('/', {
            templateUrl: 'home.html',
            controller: 'homeCtrl'
        })
        .when('/posts', {
            templateUrl: 'posts.html',
            controller: 'postsCtrl'
        })
        .when('/posts/:postId', {
            templateUrl: "post.html",
            controller: 'postCtrl'
        })
        .otherwise({ // дефаулт
            template: '<h1>404 no such page</h1>'
        })
});

app.controller('homeCtrl', function ($scope) {
    console.log('HomeCtrl');
    $scope.model = {
        message: 'homeCtrl homeCtrl homeCtrl'
    }
});

app.controller('postsCtrl', function ($scope, postsFactory) {
    console.log('postsCtrl');
    $scope.posts = postsFactory
});

app.controller('postCtrl', function ($scope, $routeParams, postsFactory) {
    console.log("$routeParams", $routeParams) // динамический ид

    var postId = +($routeParams.postId);
    $scope.post = postsFactory.filter(e => e.id === postId )[0]
    console.log("$scope.post == ",$scope.post)
});

app.factory('postsFactory', function () {
    return [
        {
            id: 1,
            name: '11Why AngularJS is good?'
        },
        {
            id: 2,
            name: '22I love AngularJS'
        },
        {
            id: 3,
            name: '33Is AngularJS easy to learn'
        }
    ]
});;