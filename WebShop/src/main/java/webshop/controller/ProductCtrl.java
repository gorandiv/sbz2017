package webshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import webshop.entity.Product;
import webshop.entity.ProductSearch;
import webshop.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductCtrl {

	@Autowired
	private ProductService productService;
	
	@PostMapping(path = "/search")
	public List<Product> searchProducts(@RequestBody ProductSearch search) {
		return productService.searchProducts(search);
	}
	

	@GetMapping(path = "/update-refill-get")
	public List<Product> getProductsAndUpdateRefill() {
		return productService.getProductsAndUpdateRefill();
	}

	
	@PostMapping(path = "/order/{productId}/{amount}")
	public Product orderProducts(@PathVariable("productId") Integer productId, @PathVariable("amount") Integer amount) {
		return productService.orderProducts(productId, amount);
	}
	
	@GetMapping(path = "/get")
	public List<Product> getProducts() {
		return productService.getProducts();
	}

}
