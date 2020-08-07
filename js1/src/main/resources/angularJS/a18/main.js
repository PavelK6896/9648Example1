var app = angular.module('app', []);


app.controller('mainCtrl', function($http, $scope) {
    console.log('mainCtrl');

    $http({
        method: 'GET',
        url: 'http://localhost:3001/books'
    }).then(function successCallback(response) {
        console.log('success', response);
        console.log('success', response.data);
        $scope.books = response.data;

    }, function errorCallback(response) {
        console.log('error', response);
    });

    $scope.addBook = function (book) {
        console.log(book);
        $http.post('http://localhost:3001/books', book)
            .then(function successCallback(response) {
                console.log('success', response.data);
                $scope.books.push(response.data)
                $scope.book = null;


            }, function errorCallback(response) {
                console.log('error', response);
            });
    };


});













// app.controller('c1', function($http) {
//
//     // $http.get('/someUrl', config).then(successCallback, errorCallback);
//     // $http.post('/someUrl', data, config).then(successCallback, errorCallback);
//
//     $http({
//         method: 'GET',
//         url: 'http://localhost:3000/books'
//     }).then(function successCallback(response) {
//         console.log('success', response);
//         console.log('success', response.data);
//         // this callback will be called asynchronously
//         // when the response is available
//     }, function errorCallback(response) {
//         console.log('error', response);
//
//         // called asynchronously if an error occurs
//         // or server returns response with an error status.
//     });
//
//     // var req = {
//     //     method: 'POST',
//     //     url: 'http://example.com',
//     //     headers: {
//     //         'Content-Type': undefined
//     //     },
//     //     data: { test: 'test' }
//     // }
//     //
//     // $http(req).then(function(){}, function(){});
//     //
//
//
//
//
// });