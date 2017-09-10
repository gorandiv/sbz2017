package webshop.service;

import java.util.List;
import java.util.Map;

import webshop.entity.Receipt;

public interface ReceiptService {

	List<Receipt> getBuyerReceipts(Integer buyerId);

	Receipt createReceipt(Integer buyerId, Map<Integer, Integer> productAmountMap);

	List<Receipt> getReceipts();

	Receipt processReceipt(Receipt receipt);

	void declineReceipt(Integer receiptId);

	Receipt purchase(Receipt receipt, Integer buyerId, Integer rewardPoints);

}
