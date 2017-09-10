var user = angular.module('user', []);

user.controller('userCtrl', ['$scope', 'loginService', 'authenticationService', function($scope, loginService, authenticationService) {

	authenticationService.authenticate();
	
	$scope.user = {
		username : '',
		password : ''
	};

	$scope.login = function() {
		loginService.login($scope.user);
	}
	
}]);

user.service('loginService', ['$http', '$cookies', '$location', function($http, $cookies, $location) {
	
	this.login = function(user) {
		$http({
			  method: 'POST',
			  url: '../WebShop/user/login/' + user.username + "/" + user.password
			}).then(function successCallback(response) {
				$cookies.put('user', angular.toJson(response.data));
				if(response.data.userType == 'BUYER') {
					$location.path('buyer');
				}
				else if(response.data.userType == 'SALESMAN') {
					$location.path('salesman');
				}
				else if(response.data.userType == 'MANAGER') {
					$location.path('manager');
				}
			  }, function errorCallback(response) {
				  toastr.error(response.data);
			  });
		}
	
}]);

user.service('logoutService', ['$http', '$cookies', '$location', function($http, $cookies, $location) {
	
	this.logout = function() {
		$http({
			  method: 'DELETE',
			  url: '../WebShop/user/logout/' + $cookies.getObject('user').id
			}).then(function successCallback(response) {
				$cookies.remove('user');
				$location.path('login');
			  }, function errorCallback(response) {
				  toastr.error(response.data);
			  });
		}
	
}]);

user.service('authenticationService', ['$cookies','$location',  function($cookies, $location){
	
	this.authenticate = function() {
		var user = $cookies.getObject('user');
		
		if(user != undefined) {
			if(user.userType == 'BUYER') {
				$location.path('buyer');
			}
			else if(user.userType == 'SALESMAN') {
				$location.path('salesman');
			}
			else if(user.userType == 'MANAGER') {
				$location.path('manager');
			}
		}
		else {
			$location.path('login');
		}
		
	}	
	
}]);