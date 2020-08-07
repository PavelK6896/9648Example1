var app = angular.module('app', []);

//<p> 30 Тестируем фабрики в AngularJS - Monsterlessons.com </p>
// npm i -g karma-cli
// karma init karma.conf.js

//  npm install karma --save-dev



app.factory('playlist', function () {
    var tracks = [
        {
            id: 1,
            name: 'Track 01'
        },
        {
            id: 2,
            name: 'Track 02'
        }
    ];
    return {
        name: 'Metallica',
        getTracks: function () {
            return tracks;
        }
    }
});
