package webshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import webshop.entity.BuyerCategory;
import webshop.service.BuyerCategoryService;

@RestController
@RequestMapping("/buyer-category")
public class BuyerCategoryCtrl {
	
	@Autowired
	private BuyerCategoryService buyerCategoryService;
	
	
	@PostMapping(path = "/save-changes", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public BuyerCategory saveChanges(@RequestBody BuyerCategory buyerCategory) {
		return buyerCategoryService.saveChanges(buyerCategory);
	}
	
	@GetMapping(path = "/get", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<BuyerCategory> getBuyerCategories() {
		return buyerCategoryService.getBuyerCategories();
	}
	

}
