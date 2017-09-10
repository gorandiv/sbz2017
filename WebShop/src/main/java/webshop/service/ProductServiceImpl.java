package webshop.service;

import java.util.ArrayList;
import java.util.List;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webshop.dao.ProductDao;
import webshop.entity.Product;
import webshop.entity.ProductSearch;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;

	@Override
	public List<Product> getProducts() {
		return productDao.findActiveProducts();
	}

	@Override
	public List<Product> searchProducts(ProductSearch search) {

		List<Product> products = productDao.searchActiveProducts(search.getCode(), search.getName(),
				search.getCategoryId(), search.getFrom(), search.getTo());
		if (products == null)
			return new ArrayList<Product>();

		return products;

	}

	@Override
	public List<Product> getProductsAndUpdateRefill() {

		KieServices kieService = KieServices.Factory.get();
		KieContainer container = kieService.getKieClasspathContainer();
		KieSession session = container.newKieSession("session");

		List<Product> products = productDao.findAll();

		for (Product product : products) {
			session.insert(product);
		}

		session.fireAllRules();

		return productDao.findAll();
	}

	@Override
	public Product orderProducts(Integer productId, Integer amount) {

		Product product = productDao.findById(productId);

		product.setQuantity(product.getQuantity() + amount);

		KieServices kieService = KieServices.Factory.get();
		KieContainer container = kieService.getKieClasspathContainer();
		KieSession session = container.newKieSession("session");

		session.insert(product);
		session.fireAllRules();

		return productDao.save(product);
	}

}
