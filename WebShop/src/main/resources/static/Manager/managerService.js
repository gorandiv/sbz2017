manager.service('buyerCategoryService', ['$http', function($http) {
	
	this.getBuyerCategories = function() {

		return $http({
			method : 'GET',
			url : '../WebShop/buyer-category/get'
		}).then(function successCallback(response) {
			return response.data;
		}, function errorCallback(response) {

		});
	}
	
	this.saveChanges = function(buyerCategory) {

		return $http({
			method : 'POST',
			url : '../WebShop/buyer-category/save-changes',
			data : angular.toJson(buyerCategory)
		}).then(function successCallback(response) {
			toastr.success("Successfully saved changes.");
			return response.data;
		}, function errorCallback(response) {

		});
	}
	
	
}]);

//calculus-function-service

manager.service('calculusFunctionService', ['$http', function($http) {
	
	this.getCalculusFunctions = function() {

		return $http({
			method : 'GET',
			url : '../WebShop/calculus-function/get'
		}).then(function successCallback(response) {
			return response.data;
		}, function errorCallback(response) {

		});
	}
	
}]);