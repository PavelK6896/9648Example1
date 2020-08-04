var app = angular.module('app', []);

app.directive('fooBar', function () {
    return {
        restrict: 'M', // как создовалась деректива указатель E второй способ
        //1 E attribute
        //2 A tag
        // по умолчанию EA
        //3 C трети ограничивать-restrict через клас
        //4 M четвертый способ комент
        link: function () {
            console.log('fooBarM');
        }
    }
});