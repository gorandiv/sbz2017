package webshop.service;

import java.util.List;

import webshop.entity.BuyerCategory;

public interface BuyerCategoryService {

	List<BuyerCategory> getBuyerCategories();

	BuyerCategory saveChanges(BuyerCategory buyerCategory);

}
