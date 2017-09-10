package webshop.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "receipt_item")
public class ReceiptItem implements Serializable {

	private static final long serialVersionUID = -2696646190993252718L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@ManyToOne
	@JsonBackReference
	private Receipt receipt;

	@Column(name = "ordinal")
	private Integer ordinal;

	@ManyToOne
	private Product product;

	@Column(name = "product_prize")
	private Double productPrize;

	@Column(name = "amount")
	private Integer amount;

	@Column(name = "original_total_prize")
	private Double originalTotalPrize;

	@Column(name = "discount_percentage")
	private Double discountPercentage;

	@Column(name = "final_total_prize")
	private Double finalTotalPrize;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonManagedReference
	private List<ReceiptItemDiscount> discounts;

	public ReceiptItem() {
	}

	public ReceiptItem(Receipt receipt, Integer ordinal, Product product, Double productPrize, Integer amount,
			Double originalTotalPrize, Double discountPercentage, Double finalTotalPrize) {
		this.receipt = receipt;
		this.ordinal = ordinal;
		this.product = product;
		this.productPrize = productPrize;
		this.amount = amount;
		this.originalTotalPrize = originalTotalPrize;
		this.discountPercentage = discountPercentage;
		this.finalTotalPrize = finalTotalPrize;
	}

	public ReceiptItem(Receipt receipt, Integer ordinal, Product product, Double productPrize, Integer amount,
			Double originalTotalPrize, Double discountPercentage, Double finalTotalPrize,
			List<ReceiptItemDiscount> discounts) {
		this.receipt = receipt;
		this.ordinal = ordinal;
		this.product = product;
		this.productPrize = productPrize;
		this.amount = amount;
		this.originalTotalPrize = originalTotalPrize;
		this.discountPercentage = discountPercentage;
		this.finalTotalPrize = finalTotalPrize;
		this.discounts = discounts;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Receipt getReceipt() {
		return receipt;
	}

	public void setReceipt(Receipt receipt) {
		this.receipt = receipt;
	}

	public Integer getOrdinal() {
		return ordinal;
	}

	public void setOrdinal(Integer ordinal) {
		this.ordinal = ordinal;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Double getProductPrize() {
		return productPrize;
	}

	public void setProductPrize(Double productPrize) {
		this.productPrize = productPrize;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Double getOriginalTotalPrize() {
		return originalTotalPrize;
	}

	public void setOriginalTotalPrize(Double originalTotalPrize) {
		this.originalTotalPrize = originalTotalPrize;
	}

	public Double getDiscountPercentage() {
		return discountPercentage;
	}

	public void setDiscountPercentage(Double discountPercentage) {
		this.discountPercentage = discountPercentage;
	}

	public Double getFinalTotalPrize() {
		return finalTotalPrize;
	}

	public void setFinalTotalPrize(Double finalTotalPrize) {
		this.finalTotalPrize = finalTotalPrize;
	}

	public List<ReceiptItemDiscount> getDiscounts() {
		return discounts;
	}

	public void setDiscounts(List<ReceiptItemDiscount> discounts) {
		this.discounts = discounts;
	}
	
	
	public void addDiscount(ReceiptItemDiscount discount) {
		discounts.add(discount);
	}
	
	

}
