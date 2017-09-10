buyer.service('actionSaleService', ['$http', function($http) {
	
	this.getActionSales = function() {
		
		return $http({
			  method: 'GET',
			  url: '../WebShop/action-sale/get'
			}).then(function successCallback(response) {
				return response.data;
			  }, function errorCallback(response) {
				  
			  });
		}
	
	this.createActionSale = function(actionSales, actionSale) {
		
		for(var i = 0; i < actionSales.length; i++) {
			if(actionSales[i].code == actionSale.code) {
				toastr.error("Action sale with choosen code already exists.");
				return;
			}
		}
		
		if(actionSale.code == "" || actionSale.name == "" || actionSale.startDate == "" || actionSale.endDate == "" || actionSale.startDate == null || actionSale.endDate == null  || actionSale.productCategories.length == 0) {
			toastr.warning("Code, name, period and atleast one category must be choosen.");
			return;
		}
		
		if(actionSale.endDate <= actionSale.startDate) {
			toastr.warning("End date must be after start date.");
			return;
		}
		
		actionSale.startDate = (actionSale.startDate.getMonth() + 1) + '/' + actionSale.startDate.getDate() + '/' +  actionSale.startDate.getFullYear();
		actionSale.endDate = (actionSale.endDate.getMonth() + 1) + '/' + actionSale.endDate.getDate() + '/' +  actionSale.endDate.getFullYear();
		
		console.log(actionSale)
		
		return $http({
			  method: 'POST',
			  url: '../WebShop/action-sale/create',
			  data: angular.toJson(actionSale)
			}).then(function successCallback(response) {
				toastr.success("Action sale successfully created.");
				return response.data;
			  }, function errorCallback(response) {
				  
			  });
		}
	
	this.saveChanges = function(actionSale) {
		
		if(actionSale.name == "" || actionSale.startDate == "" || actionSale.endDate == "" || actionSale.startDate == null || actionSale.endDate == null || actionSale.productCategories.length == 0) {
			toastr.warning("Name, period and atleast one category must be choosen.");
			return;
		}
		
		if(actionSale.endDate <= actionSale.startDate) {
			toastr.warning("End date must be after start date.");
			return;
		}
		
		actionSale.startDate = (actionSale.startDate.getMonth() + 1) + '/' + actionSale.startDate.getDate() + '/' +  actionSale.startDate.getFullYear();
		actionSale.endDate = (actionSale.endDate.getMonth() + 1) + '/' + actionSale.endDate.getDate() + '/' +  actionSale.endDate.getFullYear();
		
		
		console.log(actionSale)
		
		return $http({
			  method: 'POST',
			  url: '../WebShop/action-sale/save-changes',
			  data: angular.toJson(actionSale)
			}).then(function successCallback(response) {
				toastr.success("Action sale successfully edited.");
				return response.data;
			  }, function errorCallback(response) {
				  
			  });
		}
	
	this.isThisProductOnActionSale = function(actionSale, product) {
		for (var i = 0; i < actionSale.productCategories.length; i++) {
	    	if(actionSale.productCategories[i].id == product.category.id || ( product.category.parentCategory != null && product.category.parentCategory.id == actionSale.productCategories[i].id)) {
	    		return true;
	    	}
	    }
	    return false;
	}
	
	this.ActionSale = function() {
		this.code = "";
		this.name = "";
		this.startDate = "";
		this.endDate = "";
		this.discountPercentage = 0.0;
		this.productCategories = [];
	}
	
}]);

//product-category-service
buyer.service('productCategoryService', ['$http', function($http) {
	
	this.getProductCategories = function() {
		
		return $http({
			  method: 'GET',
			  url: '../WebShop/product-category/get'
			}).then(function successCallback(response) {
				return response.data;
			  }, function errorCallback(response) {
				  
			  });
		}
	
	this.createProductCategory = function(categories, category) {
		
		for(var i = 0; i < categories.length; i++) {
			if(categories[i].code == category.code) {
				toastr.error("Category with choosen code already exists.");
				return;
			}
		}
		
		if(category.code == "" || category.name == "") {
			toastr.warning("Code and name must be choosen.");
			return;
		}
			
		
		return $http({
			  method: 'POST',
			  url: '../WebShop/product-category/create',
			  data: angular.toJson(category)
			}).then(function successCallback(response) {
				toastr.success("Product category successfully created.");
				return response.data;
			  }, function errorCallback(response) {
				  
			  });
	}
	
	this.saveChanges = function(categories, category) {
		
		if(category.name == "") {
			toastr.warning("Name must be choosen.");
			return;
		}
		
		if(category.parentCategory != null && category.id == category.parentCategory.id) {
			toastr.warning("Category cannot have itself as parent.");
			return;
		}
		
		if(category.parentCategory != null && category.parentCategory.parentCategory != null && category.id == category.parentCategory.parentCategory.id) {
			toastr.warning("This category is parent of choosen parent category.");
			return;
		}
		
		return $http({
			  method: 'POST',
			  url: '../WebShop/product-category/save-changes',
			  data: angular.toJson(category)
			}).then(function successCallback(response) {
				toastr.success("Product category successfully edited.");
				return response.data;
			  }, function errorCallback(response) {
				  
			  });
	}
	
	this.ProductCategory = function() {
		this.code = "";
		this.name = "";
		this.parentCategory = null;
		this.maximumDiscount = 0;
	}
	
	
}]);

//product service

buyer.service('productService', [ '$http', function($http) {

	this.getProducts = function() {

		return $http({
			method : 'GET',
			url : '../WebShop/product/get'
		}).then(function successCallback(response) {
			return response.data;
		}, function errorCallback(response) {

		});
	}

	this.searchProducts = function(productSearch) {

		return $http({
			method : 'POST',
			url : '../WebShop/product/search',
			data: angular.toJson(productSearch)
		}).then(function successCallback(response) {
			return response.data;
		}, function errorCallback(response) {

		});
	}
	
	this.getProductsAndUpdateRefill = function() {

		return $http({
			method : 'GET',
			url : '../WebShop/product/update-refill-get'
		}).then(function successCallback(response) {
			return response.data;
		}, function errorCallback(response) {

		});
	}
	
	this.orderProducts = function(order) {
		return $http({
			method : 'POST',
			url : '../WebShop/product/order/' + order.product.id + '/' + order.amount
		}).then(function successCallback(response) {
			return response.data;
		}, function errorCallback(response) {

		});
	}

} ]);

//profile service

buyer.service('profileService', ['$http', '$cookies', function($http, $cookies) {
	
	this.getBuyerProfile = function() {
		
		return $http({
			  method: 'GET',
			  url: '../WebShop/profile/get/' + $cookies.getObject('user').id
			}).then(function successCallback(response) {
				return response.data;
			  }, function errorCallback(response) {
				  
			  });
		}
	
	
}]);

//receipt service

buyer.service('receiptService', ['$http', '$cookies', function($http, $cookies) {
	
	this.getBuyerReceipts = function() {
		
		return $http({
			  method: 'GET',
			  url: '../WebShop/receipt/get/' + $cookies.getObject('user').id
			}).then(function successCallback(response) {
				return response.data;
			  }, function errorCallback(response) {
				  
			  });
		}
	
	this.createReceipt = function(productCart) {
		
		return $http({
			  method: 'POST',
			  url: '../WebShop/receipt/create-receipt/' + $cookies.getObject('user').id,
			  data : angular.toJson(productCart)
			}).then(function successCallback(response) {
				toastr.success("Receipt successfuly created!");
				return response.data;
			  }, function errorCallback(response) {
				  
			  });
		}
	
	this.makePurchase = function(receipt, rewardPoints) {
		
		return $http({
			  method: 'POST',
			  url: '../WebShop/receipt/purchase/' + $cookies.getObject('user').id + '/'+ rewardPoints,
			  data : angular.toJson(receipt)
			}).then(function successCallback(response) {
				toastr.success("Purchase successfuly made!");
				return response.data;
			  }, function errorCallback(response) {
				  
			  });
		}
	
	
	this.getReceipts = function() {
		return $http({
			  method: 'GET',
			  url: '../WebShop/receipt/get'
			}).then(function successCallback(response) {
				return response.data;
			  }, function errorCallback(response) {
				  
			  });
		}
	
	this.processReceipt = function(receipt) {
		return $http({
			  method: 'POST',
			  url: '../WebShop/receipt/process',
			  data: angular.toJson(receipt)
			}).then(function successCallback(response) {
				if(response.data.state == 'PENDING') {
					toastr.error("Receipt realization unsuccessful!");
				} else {
					toastr.success("Receipt successfuly realized!");
				}
				return response.data;
			  }, function errorCallback(response) {
				  
			  });
	}
	
	this.declineReceipt = function(receipt) {
		$http({
			  method: 'PUT',
			  url: '../WebShop/receipt/decline/' + receipt.id,
			}).then(function successCallback(response) {
				toastr.success("Receipt successfuly declined!");
			  }, function errorCallback(response) {
				  
			  });
	}
	
}]);

//util service

buyer.service('utilService', function() {
	
	
	this.isEmpty = function(obj) {
	    for(var key in obj) {
	        if(obj.hasOwnProperty(key))
	            return false;
	    }
	    return true;
	}
	
});