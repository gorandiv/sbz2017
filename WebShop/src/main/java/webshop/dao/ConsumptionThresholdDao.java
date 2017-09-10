package webshop.dao;

import org.springframework.data.repository.Repository;

import webshop.entity.ConsumptionThreshold;

public interface ConsumptionThresholdDao extends Repository<ConsumptionThreshold, Integer> {
	
	ConsumptionThreshold save(ConsumptionThreshold consumptionThreshold);

}
