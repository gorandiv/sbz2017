var app = angular.module('app', ['ngRoute', 'ngCookies', 'user', 'buyer', 'salesman', 'manager']);

app.config(function($routeProvider, $locationProvider) {
	$locationProvider.hashPrefix('');
    $routeProvider
        .when('/buyer', {
            templateUrl : 'WebShop/Buyer/buyer.html',
            controller  : 'buyerCtrl'
        })
        .when('/salesman', {
            templateUrl : 'WebShop/Salesman/salesman.html',
            controller  : 'salesmanCtrl'
        })
        .when('/manager', {
            templateUrl : 'WebShop/Manager/manager.html',
            controller  : 'managerCtrl'
        })
        .otherwise({
        	 templateUrl : 'WebShop/User/login.html',
             controller  : 'userCtrl'
          });
});

