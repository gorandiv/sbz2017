var salesman = angular.module('salesman', []);

salesman.controller('salesmanCtrl', ['$scope', 'logoutService', 'authenticationService', function($scope, logoutService, authenticationService) {
	
	authenticationService.authenticate();
	
	$scope.logout = function() {
		logoutService.logout();
	}
	
}]);
