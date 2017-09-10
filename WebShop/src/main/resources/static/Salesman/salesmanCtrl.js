salesman.controller('procurementCtrl', ['$scope', 'productService', function($scope, productService) {
	
	
	productService.getProductsAndUpdateRefill().then(function(data) {
		$scope.products = data;
	});
	
	$scope.data = {amounts : []}
	$scope.productsToOrder = new Object();
	$scope.order = {product : null, amount : null}
	
	$scope.setOrder = function(product, amount) {
		$scope.order.product = product;
		$scope.order.amount = amount;
	}
	
	$scope.orderProduct = function() {
		productService.orderProducts($scope.order).then(function(data) {
			for(var i = 0; i < $scope.products.length; i++) {
				if($scope.products[i].id == data.id) {
					$scope.products[i] = data;
					break;
				}
			}
		});
	}
	
	
}]);

salesman.controller('receiptCtrl', ['$scope', 'receiptService', function($scope, receiptService) {
	
	receiptService.getReceipts().then(function(data) {
		$scope.receipts = data;
	});
	
	$scope.status = 'PENDING';
	
	$scope.processReceipt = function(receipt) {
		receiptService.processReceipt(receipt).then(function(data) {
			
			for(var i = 0; i < $scope.receipts.length; i++) {
				if($scope.receipts[i].id == data.id) {
					$scope.receipts[i] = data;
					break;
				}
			}
		});
	}
	
	$scope.declineReceipt = function(receipt) {
		receiptService.declineReceipt(receipt);
		receipt.state = 'DECLINED';
	}
		
	
}]);