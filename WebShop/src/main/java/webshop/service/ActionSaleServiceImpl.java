package webshop.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webshop.dao.ActionSaleDao;
import webshop.entity.ActionSale;

@Service
public class ActionSaleServiceImpl implements ActionSaleService {

	@Autowired
	private ActionSaleDao actionSaleDao;

	@Override
	public List<ActionSale> getActionSales() {
		return actionSaleDao.findAll();
	}

	@Override
	public ActionSale createActionSale(ActionSale actionSale) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			actionSale.setEndDate(sdf.format(sdf.parse(actionSale.getEndDate())));
			actionSale.setStartDate(sdf.format(sdf.parse(actionSale.getStartDate())));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return actionSaleDao.save(actionSale);
	}

	@Override
	public ActionSale saveChanges(ActionSale actionSale) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			actionSale.setEndDate(sdf.format(sdf.parse(actionSale.getEndDate())));
			actionSale.setStartDate(sdf.format(sdf.parse(actionSale.getStartDate())));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return actionSaleDao.save(actionSale);
	}
	
}
