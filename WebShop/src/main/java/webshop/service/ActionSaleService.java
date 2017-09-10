package webshop.service;

import java.util.List;

import webshop.entity.ActionSale;

public interface ActionSaleService {

	List<ActionSale> getActionSales();

	ActionSale createActionSale(ActionSale actionSale);

	ActionSale saveChanges(ActionSale actionSale);

}
