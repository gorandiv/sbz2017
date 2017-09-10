package webshop.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webshop.dao.ActionSaleDao;
import webshop.dao.ProductCategoryDao;
import webshop.dao.ProductDao;
import webshop.dao.ProfileDao;
import webshop.dao.ReceiptDao;
import webshop.dao.UserDao;
import webshop.entity.ActionSale;
import webshop.entity.ConsumptionThreshold;
import webshop.entity.Product;
import webshop.entity.ProductCategory;
import webshop.entity.Profile;
import webshop.entity.Receipt;
import webshop.entity.ReceiptDiscount;
import webshop.entity.ReceiptItem;
import webshop.entity.ReceiptItemDiscount;
import webshop.entity.ReceiptState;

@Service
public class ReceiptServiceImpl implements ReceiptService {

	@Autowired
	private ReceiptDao receiptDao;

	@Autowired
	private UserDao userDao;

	@Autowired
	private ProductDao productDao;

	@Autowired
	private ActionSaleDao actionSaleDao;

	@Autowired
	private ProductCategoryDao productCategoryDao;

	@Autowired
	private ProfileDao profileDao;

	@Override
	public List<Receipt> getBuyerReceipts(Integer buyerId) {
		return receiptDao.findByBuyer_Id(buyerId);
	}
	
	@PersistenceContext
    private EntityManager em;

	@Override
	public Receipt createReceipt(Integer buyerId, Map<Integer, Integer> productAmountMap) {

		KieServices kieService = KieServices.Factory.get();
		KieContainer container = kieService.getKieClasspathContainer();
		KieSession session = container.newKieSession("session");

		Receipt receipt = new Receipt();
		Set<ReceiptItem> items = new HashSet<ReceiptItem>();
		
	    em.detach(receipt);

		Double originalPrize = new Double(0.0);
		List<ActionSale> actionSales = actionSaleDao.findAll();

		Integer index = 0;
		for (Integer key : productAmountMap.keySet()) {
			Product product = productDao.findById(key);
			index++;

			ReceiptItem receiptItem = new ReceiptItem();

			receiptItem.setOrdinal(index);
			receiptItem.setAmount(productAmountMap.get(key));
			receiptItem.setProduct(product);
			receiptItem.setProductPrize(product.getPrize());
			receiptItem.setOriginalTotalPrize(receiptItem.getProductPrize() * receiptItem.getAmount());
			receiptItem.setDiscountPercentage(0.0);
			receiptItem.setDiscounts(new ArrayList<ReceiptItemDiscount>());
			receiptItem.setReceipt(receipt);

			originalPrize += receiptItem.getAmount() * receiptItem.getProductPrize();

			items.add(receiptItem);
		}

		receipt.setItems(items);
		receipt.setBuyer(userDao.findById(buyerId));

		Integer randCode = new Random().nextInt(10000) + 1;

		receipt.setCode(randCode.toString());
		receipt.setDate(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
		receipt.setOriginalPrize(originalPrize);
		receipt.setState(ReceiptState.PENDING);
		receipt.setDiscountPercentage(0.0);
		receipt.setFinalPrize(0.0);
		receipt.setDiscounts(new HashSet<ReceiptDiscount>());

		for (ReceiptItem item : receipt.getItems()) {
			session.insert(item);

			for (ActionSale actionSale : actionSales) {
				session.insert(actionSale);
			}
			session.fireAllRules();
		}

		Profile profile = profileDao.findByBuyer_Id(buyerId);

		session.insert(profile);
		session.insert(receipt);
		session.fireAllRules();

		return receipt;
	}

	@Override
	public Receipt purchase(Receipt receipt, Integer buyerId, Integer rewardPoints) {
		
		
		KieServices kieService = KieServices.Factory.get();
		KieContainer container = kieService.getKieClasspathContainer();
		KieSession session = container.newKieSession("session");

		receipt.setRewardPointsSpent(rewardPoints);
		receipt.setRewardPointsAcquired(0);
		
		Profile profile = profileDao.findByBuyer_Id(buyerId);
		
		session.insert(receipt);
		
		for(ConsumptionThreshold ct : profile.getCategory().getConsumptionThresholds()) {
			session.insert(ct);
		}
		
		session.fireAllRules();
		
		return receiptDao.save(receipt);
	}

	@Override
	public List<Receipt> getReceipts() {
		return receiptDao.findAll();
	}
	
	@Override
	public Receipt processReceipt(Receipt receipt) {

		receipt.setState(ReceiptState.REALIZED);
		
		for(ReceiptItem item : receipt.getItems()) {
			if(item.getAmount() > item.getProduct().getQuantity()) {
				receipt.setState(ReceiptState.PENDING);
				break;
			}
		}
		
		if(receipt.getState().equals(ReceiptState.REALIZED)) {
			
			for(ReceiptItem item : receipt.getItems()) {
				Product product = item.getProduct();
				product.setQuantity(item.getProduct().getQuantity() - item.getAmount());
				product.setLastPurchaseDate(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
				productDao.save(product);
				ProductCategory category = product.getCategory();
				category.setLastPurchaseDate(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
				productCategoryDao.save(category);
			}
			
			
			Profile profile = profileDao.findByBuyer_Id(receipt.getBuyer().getId());
			
			profile.setRewardPoints(profile.getRewardPoints() - receipt.getRewardPointsSpent() + receipt.getRewardPointsAcquired());
			
			if(profile.getRealizedReceipts() == null) {
				profile.setRealizedReceipts(new HashSet<Receipt>());
			}
			profile.addRealizedReceipt(receipt);
			
			profileDao.save(profile);
			
		}
		

		return receiptDao.save(receipt);

	}

	@Override
	public void declineReceipt(Integer receiptId) {
		Receipt receipt = receiptDao.findById(receiptId);

		receipt.setState(ReceiptState.DECLINED);

		receiptDao.save(receipt);

	}

}
