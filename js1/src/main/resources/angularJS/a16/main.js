var app = angular.module('app', []);

app.controller('firstCtrl', function ($scope) {
    $scope.name = 'Harry';
    $scope.color = '#222';
    $scope.reverse = () => {
        //split разбить посимвольно //join склеить
        $scope.name = $scope.name.split('').reverse().join('');
        $scope.color = $scope.color.split('').reverse().join('');
    }
});

app.directive('fooBar', function () {
    return {
        scope: { // изолированный скоп
            name1: '@', // только для чтения
            color1: '=', // двухстронний биндинг
            reverse: '&', // для функций
        },
        template: `<div>My name is {{name1}} <input type='text' ng-model='name1'></div>
<div>My color is {{color1}} <input type='text' ng-model='color1'></div>
<button ng-click='reverse()'>Reverse</button>`,
        link: function ($scope, element, attrs) {
            console.log('fooBar');
        }
    };
});
