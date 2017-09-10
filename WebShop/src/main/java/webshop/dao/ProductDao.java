package webshop.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import webshop.entity.Product;

public interface ProductDao extends Repository<Product, Integer> {

	@Query("from Product p where p.active = true")
	List<Product> findActiveProducts();

	@Query("from Product p where p.active = true and (p.code = :code or :code = '') and (p.name = :name or :name = '') and (p.category.id = :categoryId or :categoryId is null or p.category.parentCategory.id = :categoryId) and p.prize between :from and :to")
	List<Product> searchActiveProducts(@Param("code") String code, @Param("name") String name,
			@Param("categoryId") Integer categoryId, @Param("from") Double from, @Param("to") Double to);

	List<Product> findAll();

	Product findById(Integer productId);

	Product save(Product product);

}
