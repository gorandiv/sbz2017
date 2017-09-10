var manager = angular.module('manager', []);

manager.controller('managerCtrl', ['$scope', 'logoutService', 'authenticationService', function($scope, logoutService, authenticationService) {
	
	authenticationService.authenticate();
	
	$scope.logout = function() {
		logoutService.logout();
	}
	
}]);
