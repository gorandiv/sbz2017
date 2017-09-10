package webshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import webshop.entity.CalculusFunction;
import webshop.service.CalculusFunctionService;

@RestController
@RequestMapping("/calculus-function")
public class CalculusFunctionCtrl {
	
	@Autowired
	private CalculusFunctionService calculusFunctionService;
	
	@GetMapping(path = "/get")
	public CalculusFunction[] getCalculusFunctions() {
		return calculusFunctionService.getCalculusFunctions();
	}
	
}
