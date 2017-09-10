package webshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import webshop.entity.ProductCategory;
import webshop.service.ProductCategoryService;

@RestController
@RequestMapping("/product-category")
public class ProductCategoryCtrl {
	
	@Autowired
	private ProductCategoryService productCategoryService;
	
	
	
	@GetMapping(path = "/get")
	public List<ProductCategory> getProductCategories() {
		return productCategoryService.getProductCategories();
	}
	
	@PostMapping(path = "/save-changes", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ProductCategory saveChanges(@RequestBody ProductCategory productCategory) {
		return productCategoryService.saveChanges(productCategory);
	}
	
	@PostMapping(path = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ProductCategory createProductCategory(@RequestBody ProductCategory productCategory) {
		return productCategoryService.createProductCategory(productCategory);
	}
	


}
