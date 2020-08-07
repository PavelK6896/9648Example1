var app = angular.module('app', ['ngMockE2E']);


app.run(function ($httpBackend) {
    console.log('RUN APP');

    var books = [
        {
            name: 'AngularJS'
        },
        {
            name: 'EmberJS'
        },
        {
            name: 'ReactJS'
        }
    ];

    $httpBackend.whenGET('http://localhost:3001/books').respond(200, books);

    $httpBackend.whenPOST('http://localhost:3001/books').respond(function (method, url, data) {
        console.log('method', method);
        console.log('url', url);
        console.log('data', data);
        var result = JSON.parse(data);
        books.push(result);
        return [200, result];
    })

});

app.controller('mainCtrl', function ($http, $scope) {
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

