package webshop.service;

import java.util.List;

import webshop.entity.Product;
import webshop.entity.ProductSearch;

public interface ProductService {

	List<Product> getProducts();

	List<Product> searchProducts(ProductSearch search);

	List<Product> getProductsAndUpdateRefill();

	Product orderProducts(Integer productId, Integer amount);

}
