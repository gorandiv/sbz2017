manager.controller('actionSaleCtrl', ['$scope', 'actionSaleService', 'productCategoryService',  function($scope, actionSaleService, productCategoryService) {
	
	$scope.actionSale = new actionSaleService.ActionSale();
	$scope.editActionSale = null;
	
	actionSaleService.getActionSales().then(function(data) {
		
		$scope.actionSales = data;
		
	});
	
	productCategoryService.getProductCategories().then(function(data) {
		
		$scope.categories = data;
		
	});
	
	$scope.createActionSale = function() {
		actionSaleService.createActionSale($scope.actionSales, $scope.actionSale).then(function(data){
				$scope.actionSale = new actionSaleService.ActionSale();
				$scope.actionSales.push(data);
			});
	}

	$scope.saveChanges = function() {
			actionSaleService.saveChanges($scope.editActionSale).then(function(data) {
				console.log($scope.editActionSale)
				$scope.editActionSale = null;
			});
		}
	
	$scope.setDates = function() {
		if($scope.editActionSale != null) {
			$scope.editActionSale.startDate = new Date($scope.editActionSale.startDate);
			$scope.editActionSale.endDate = new Date($scope.editActionSale.endDate);
		}
	}
	
}]);

manager.controller('buyerCategoryCtrl', [ '$scope',
	'buyerCategoryService', 'calculusFunctionService',
	function($scope, buyerCategoryService, calculusFunctionService) {

		$scope.category = null;
		$scope.editMode = true;

		buyerCategoryService.getBuyerCategories().then(function(data) {
			$scope.categories = data;
		});

		calculusFunctionService.getCalculusFunctions().then(function(data) {
			$scope.calculusFunctions = data;
		});
		
		$scope.addConsumptionThreshold = function() {
			$scope.category.consumptionThresholds.push({from : 0, to : 1000, calculusFunction:'TOTAL_2_PERCENT'});
		};
		
		$scope.saveChanges = function() {
			buyerCategoryService.saveChanges($scope.category).then(function(data) {
				$scope.category = null;
				$scope.editMode = true;
			});
		}

	} ]);

manager.controller('productCategoryCtrl', ['$scope', 'productCategoryService', function($scope, productCategoryService) {
	
	$scope.category = new productCategoryService.ProductCategory();
	$scope.editCategory = null;
	
	productCategoryService.getProductCategories().then(function(data) {
		$scope.categories = data;
	});
	
	$scope.createProductCategory = function() {
		productCategoryService.createProductCategory($scope.categories, $scope.category).then(function(data) {
			$scope.category = new productCategoryService.ProductCategory();
			$scope.categories.push(data);
			
		});
	}
	
	$scope.saveChanges = function() {
		productCategoryService.saveChanges($scope.categories, $scope.editCategory).then(function(data) {
			$scope.editCategory = null;
		});
	}
	
}]);