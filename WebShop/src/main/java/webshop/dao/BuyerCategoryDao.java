package webshop.dao;

import java.util.List;

import org.springframework.data.repository.Repository;

import webshop.entity.BuyerCategory;

public interface BuyerCategoryDao extends Repository<BuyerCategory, Integer> {
	
	List<BuyerCategory> findAll();
	
	BuyerCategory save(BuyerCategory buyerCategory);
	
}
