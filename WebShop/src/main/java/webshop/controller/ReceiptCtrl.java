package webshop.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import webshop.entity.Receipt;
import webshop.service.ReceiptService;

@RestController
@RequestMapping("/receipt")
public class ReceiptCtrl {
	
	@Autowired
	private ReceiptService receiptService;
	
	@GetMapping(path = "/get/{buyerId}")
	public List<Receipt> getBuyerReceipts(@PathVariable("buyerId") Integer buyerId) {
		return receiptService.getBuyerReceipts(buyerId);
	}
	
	@GetMapping(path = "/get")
	public List<Receipt> getReceipts() {
		return receiptService.getReceipts();
	}
	
	@PostMapping(path = "/create-receipt/{buyerId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Receipt createReceipt(@PathVariable("buyerId") Integer buyerId, @RequestBody Map<Integer, Integer> productAmountMap) {
		return receiptService.createReceipt(buyerId, productAmountMap);
	}
	
	@PostMapping(path = "/purchase/{buyerId}/{rewardPoints}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Receipt purchase(@RequestBody Receipt receipt, @PathVariable("buyerId") Integer buyerId, @PathVariable("rewardPoints") Integer rewardPoints) {
		return receiptService.purchase(receipt, buyerId, rewardPoints);
	}
	
	@PostMapping(path = "/process", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Receipt processReceipt(@RequestBody Receipt receipt) {
		return receiptService.processReceipt(receipt);
	}
	
	@PutMapping(path = "/decline/{receiptId}")
	public void declineReceipt(@PathVariable("receiptId") Integer receiptId) {
		receiptService.declineReceipt(receiptId);
	}

}
