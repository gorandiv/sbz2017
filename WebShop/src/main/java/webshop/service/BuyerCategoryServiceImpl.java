package webshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webshop.dao.BuyerCategoryDao;
import webshop.dao.ConsumptionThresholdDao;
import webshop.entity.BuyerCategory;
import webshop.entity.ConsumptionThreshold;

@Service
public class BuyerCategoryServiceImpl implements BuyerCategoryService {

	@Autowired
	private BuyerCategoryDao buyerCategoryDao;

	@Autowired
	private ConsumptionThresholdDao consumptionThresholdDao;

	@Override
	public List<BuyerCategory> getBuyerCategories() {
		return buyerCategoryDao.findAll();
	}

	@Override
	public BuyerCategory saveChanges(BuyerCategory buyerCategory) {

		
		for (ConsumptionThreshold consumptionThreshold : buyerCategory.getConsumptionThresholds()) {
			consumptionThresholdDao.save(consumptionThreshold);
		}

		return buyerCategoryDao.save(buyerCategory);
	}

}
