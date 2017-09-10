package webshop.dao;

import java.util.List;

import org.springframework.data.repository.Repository;

import webshop.entity.ProductCategory;

public interface ProductCategoryDao extends Repository<ProductCategory, Integer> {

	List<ProductCategory> findAll();

	ProductCategory save(ProductCategory productCategory);

	ProductCategory findById(Integer id);
}
