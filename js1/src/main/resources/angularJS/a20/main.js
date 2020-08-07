var app = angular.module('app', []);

app.directive('uiSource', function () {
    return {

        compile: function (elem) {

            var escape = function (content) { // игнорируем хтмл теги
                return content.replace(/\</g, '&lt;')
                    .replace(/\>/g, '&gt;');
            }

            // console.log(elem);
            var pre = angular.element('<pre class="prettyprint"></pre>'); // создали новый элемент
            var pretty = prettyPrintOne(escape(elem.html())); // модифицировали хтмл в файле

            pre.append(pretty); // в созданный ложем нашь из файла хтмл
            elem.replaceWith(pre);

            // console.log(pretty);
        }

    };
});

