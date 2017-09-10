package webshop.service;

import org.springframework.stereotype.Service;

import webshop.entity.CalculusFunction;

@Service
public class CalculusFunctionServiceImpl implements CalculusFunctionService {

	@Override
	public CalculusFunction[] getCalculusFunctions() {
		return CalculusFunction.values();
	}

}
