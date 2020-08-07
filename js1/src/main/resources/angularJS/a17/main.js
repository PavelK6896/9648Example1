var app = angular.module('app', []);

app.directive('wrapIn', function ($templateCache) {
    return {
        transclude: 'element',  // всего сразу
        // transclude: true // только содержимого внутри
        link: function (scope, element, attrs, ctrl, transclude) {
            var template = $templateCache.get(attrs.wrapIn); // форма по обертке из хеша
            var templateElement = angular.element(template); // генерировать дом елемент из хеша
            transclude(scope, function (clone) {
                // в дерективу которая обработана трансклудо добовляем форму сгенерированную из хеша
                element.after(templateElement.append(clone));
            });
        }
    };
});
