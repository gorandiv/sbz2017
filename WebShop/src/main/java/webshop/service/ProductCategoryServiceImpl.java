package webshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webshop.dao.ProductCategoryDao;
import webshop.entity.ProductCategory;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

	@Autowired
	private ProductCategoryDao productCategoryDao;
	
	@Override
	public List<ProductCategory> getProductCategories() {
		return productCategoryDao.findAll();
	}

	@Override
	public ProductCategory createProductCategory(ProductCategory productCategory) {
		return productCategoryDao.save(productCategory);
	}

	@Override
	public ProductCategory saveChanges(ProductCategory productCategory) {
		return productCategoryDao.save(productCategory);
	}

}
