var buyer = angular.module('buyer', []);

buyer.controller('buyerCtrl', ['$scope', 'logoutService', 'authenticationService', function($scope, logoutService, authenticationService) {
	
	authenticationService.authenticate();
	
	$scope.logout = function() {
		logoutService.logout();
	}
	
}]);
