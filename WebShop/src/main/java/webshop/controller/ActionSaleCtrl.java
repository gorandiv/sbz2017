package webshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import webshop.entity.ActionSale;
import webshop.service.ActionSaleService;

@RestController
@RequestMapping("/action-sale")
public class ActionSaleCtrl {
	
	
	@Autowired
	private ActionSaleService actionSaleService;
	
	@PostMapping(path = "/save-changes", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ActionSale saveChanges(@RequestBody ActionSale actionSale) {
		return actionSaleService.saveChanges(actionSale);
	}
	
	
	@GetMapping(path = "/get")
	public List<ActionSale> getActionSales() {
		return actionSaleService.getActionSales();
	}
	
	@PostMapping(path = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ActionSale createActionSale(@RequestBody ActionSale actionSale) {
		return actionSaleService.createActionSale(actionSale);
	}
	


}
