var app = angular.module('app', []);

app.directive('foo', function () {
    return function (scope, element, attrs) { // state // dom // attribute
        console.log('this is my directive = ', scope, " element = ", element, " attrs = ", attrs);
    };
});

app.directive('foo2', function () {
    return {
        link: function (scope, element, attrs) { // link хук после отрисовки
            console.log('this is my directive');
            element.on('click', function () { //вешаем слушатель обработчик
                if (element.text() === 'foo') {
                    element.text('bar');
                } else {
                    element.text('foo');
                }
            });
        }
    };
});
