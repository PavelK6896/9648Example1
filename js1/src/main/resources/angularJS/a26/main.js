angular.module('MyApp', ['ngMaterial',  ])

    .controller('AppCtrl', function ($scope) {

            $scope.z1 = 10;
            $scope.z2 = 50;
            $scope.z3 = 100;

        $scope.rating1 = 3;
        $scope.rating2 = 2;
        $scope.rating3 = 4;

        $scope.disabled1 = Math.floor(Math.random() * 100);
        $scope.disabled2 = 0;
        $scope.disabled3 = 70;

        $scope.invert = Math.floor(Math.random() * 100);

        $scope.isDisabled = true;
    });


