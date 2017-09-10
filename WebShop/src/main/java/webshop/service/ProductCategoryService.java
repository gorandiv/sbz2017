package webshop.service;

import java.util.List;

import webshop.entity.ProductCategory;

public interface ProductCategoryService {

	List<ProductCategory> getProductCategories();

	ProductCategory createProductCategory(ProductCategory productCategory);

	ProductCategory saveChanges(ProductCategory productCategory);

}
