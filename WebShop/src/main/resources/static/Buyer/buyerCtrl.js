buyer.controller('historyCtrl', ['$scope', 'receiptService', function($scope, receiptService) {
	
	receiptService.getBuyerReceipts().then(function(data) {
		$scope.receipts = data;
		console.log(data)
	});
	
}]);

buyer.controller('profileCtrl', ['$scope', 'profileService', function($scope, profileService) {
	
	profileService.getBuyerProfile().then(function(data) {
		$scope.profile = data;
	});
	
}]);

buyer.controller('shopCtrl', [ '$scope', '$rootScope', 'productService',
	'productCategoryService', 'actionSaleService', 'receiptService', 'utilService', 'profileService',
	function($scope, $rootScope, productService, productCategoryService, actionSaleService, receiptService, utilService, profileService) {

		$scope.productSearch = {
			code : "",
			name : "",
			categoryId : null,
			from : 0,
			to : 200000
		}
		
		$scope.productCart = new Object();
		$scope.productsToShow = new Object();
		$scope.rewardPoints = 0;
		
		$scope.searchProducts = function() {
			productService.searchProducts($scope.productSearch).then(function(data) {
				$scope.products = data;
				$scope.data = {amounts : []}
			});
		}
		
		actionSaleService.getActionSales().then(function(data) {
			$scope.actionSales = data;
		});
		
		profileService.getBuyerProfile().then(function(data) {
			$scope.profile = data;
		});
		
		productCategoryService.getProductCategories().then(function(data) {
			$scope.categories = data;
		});
		
		$scope.isThisProductOnActionSale = function(actionSale, product) {
		    return actionSaleService.isThisProductOnActionSale(actionSale, product);
		}
		
		$scope.addProductToCart = function(product, amount) {
			$scope.productsToShow[product.id] = {name : product.name, code : product.code, amount : amount};
			$scope.productCart[product.id] = amount;
		}
		
		$scope.removeProductFromCart = function(productId) {
			delete $scope.productsToShow[productId];
			delete $scope.productCart[productId];
		}
		
		$scope.createReceipt = function() {
			receiptService.createReceipt($scope.productCart).then(function(data) {
				$scope.receipt = data;
				$('#receiptModal').modal('show');
			});
		}
		
		$scope.isEmpty = function(obj) {
		   return utilService.isEmpty(obj);
		}
		
		$scope.makePurchase = function() {
			receiptService.makePurchase($scope.receipt, $scope.rewardPoints).then(function(data){
				$scope.productCart = new Object();
				$scope.productsToShow = new Object();
				$scope.rewardPoints = 0;
			});
		}
		
		

	} ]);

