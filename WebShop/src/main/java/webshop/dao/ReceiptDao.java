package webshop.dao;

import java.util.List;

import org.springframework.data.repository.Repository;

import webshop.entity.Receipt;

public interface ReceiptDao extends Repository<Receipt, Integer> {
	
	List<Receipt> findByBuyer_Id(Integer buyerId);

	List<Receipt> findAll();

	Receipt save(Receipt receipt);

	Receipt findById(Integer receiptId);
	
}
