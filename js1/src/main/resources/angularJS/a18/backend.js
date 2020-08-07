var express = require('express');
var cors = require('cors');
var bodyParser = require('body-parser');

var app = express(); // init server

//parser
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({
    extended: true
}));


//крос даменные запросы
app.use(cors());

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

app.get('/books', function (req, res) {
    res.send(books); // ответ
});

app.post('/books', function (req, res) {
    let r = {
        name: req.body.name
    }
    books.push(r);
    res.send(r , 200);

});


var server = app.listen(3001, function () { // старт
    console.log('backend started');
    console.log(`server listening at http://localhost:3001/books`)
});


//npm i express body-parser cors