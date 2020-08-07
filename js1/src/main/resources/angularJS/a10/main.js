var app = angular.module('app', []);

app.directive('fooBar', function () {
    var bookmarks = [
        {
            id: 1,
            name: 'AngularJS'
        },
        {
            id: 2,
            name: 'EmberJS'
        },
        {
            id: 3,
            name: 'ReactJS'
        }
    ];
    return {
        template: `
<div>
<div>Hello world {{name}} </div>

цикол в ангуляре 
<div ng-repeat='bookmark in myBookmarks'>{{bookmark.name}}</div>

</div>
`, //шаблон
        link: function (scope, element, attrs) {
            console.log('fooBarM');
            scope.name = "Sasha";
            scope.myBookmarks = bookmarks;
        }
    }
});