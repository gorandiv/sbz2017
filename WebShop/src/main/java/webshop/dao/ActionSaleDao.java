package webshop.dao;

import java.util.List;

import org.springframework.data.repository.Repository;

import webshop.entity.ActionSale;

public interface ActionSaleDao extends Repository<ActionSale, Integer> {

	List<ActionSale> findAll();

	ActionSale save(ActionSale actionSale);
	
}
