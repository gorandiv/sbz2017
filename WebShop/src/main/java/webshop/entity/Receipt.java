package webshop.entity;

import java.io.Serializable;
import java.util.Set;

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

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "receipt")
public class Receipt implements Serializable {

	private static final long serialVersionUID = -8205576631997460635L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "receipt_code")
	private String code;

	@Column(name = "receipt_date")
	private String date;

	@ManyToOne
	private Buyer buyer;

	@Column(name = "state")
	private ReceiptState state;

	@Column(name = "original_prize")
	private Double originalPrize;

	@Column(name = "discount_percentage")
	private Double discountPercentage;

	@Column(name = "final_prize")
	private Double finalPrize;

	@Column(name = "points_spent")
	private Integer rewardPointsSpent;

	@Column(name = "points_acquired")
	private Integer rewardPointsAcquired;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "receipt", orphanRemoval = true, fetch = FetchType.EAGER)
	@JsonManagedReference
	private Set<ReceiptItem> items;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "receipt", orphanRemoval = true, fetch = FetchType.EAGER)
	@JsonManagedReference
	private Set<ReceiptDiscount> discounts;

	public Receipt() {
	}

	public Receipt(String code, String date, Buyer buyer, ReceiptState state, Double originalPrize,
			Double discountPercentage, Double finalPrize, Integer rewardPointsSpent, Integer rewardPointsAcquired,
			Set<ReceiptItem> items) {
		this.code = code;
		this.date = date;
		this.buyer = buyer;
		this.state = state;
		this.originalPrize = originalPrize;
		this.discountPercentage = discountPercentage;
		this.finalPrize = finalPrize;
		this.rewardPointsSpent = rewardPointsSpent;
		this.rewardPointsAcquired = rewardPointsAcquired;
		this.items = items;
	}

	public Receipt(String code, String date, Buyer buyer, ReceiptState state, Double originalPrize,
			Double discountPercentage, Double finalPrize, Integer rewardPointsSpent, Integer rewardPointsAcquired,
			Set<ReceiptItem> items, Set<ReceiptDiscount> discounts) {
		this.code = code;
		this.date = date;
		this.buyer = buyer;
		this.state = state;
		this.originalPrize = originalPrize;
		this.discountPercentage = discountPercentage;
		this.finalPrize = finalPrize;
		this.rewardPointsSpent = rewardPointsSpent;
		this.rewardPointsAcquired = rewardPointsAcquired;
		this.items = items;
		this.discounts = discounts;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Buyer getBuyer() {
		return buyer;
	}

	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
	}

	public ReceiptState getState() {
		return state;
	}

	public void setState(ReceiptState state) {
		this.state = state;
	}

	public Double getOriginalPrize() {
		return originalPrize;
	}

	public void setOriginalPrize(Double originalPrize) {
		this.originalPrize = originalPrize;
	}

	public Double getDiscountPercentage() {
		return discountPercentage;
	}

	public void setDiscountPercentage(Double discountPercentage) {
		this.discountPercentage = discountPercentage;
	}

	public Double getFinalPrize() {
		return finalPrize;
	}

	public void setFinalPrize(Double finalPrize) {
		this.finalPrize = finalPrize;
	}

	public Integer getRewardPointsSpent() {
		return rewardPointsSpent;
	}

	public void setRewardPointsSpent(Integer rewardPointsSpent) {
		this.rewardPointsSpent = rewardPointsSpent;
	}

	public Integer getRewardPointsAcquired() {
		return rewardPointsAcquired;
	}

	public void setRewardPointsAcquired(Integer rewardPointsAcquired) {
		this.rewardPointsAcquired = rewardPointsAcquired;
	}

	public Set<ReceiptItem> getItems() {
		return items;
	}

	public void setItems(Set<ReceiptItem> items) {
		this.items = items;
	}

	public Set<ReceiptDiscount> getDiscounts() {
		return discounts;
	}

	public void setDiscounts(Set<ReceiptDiscount> discounts) {
		this.discounts = discounts;
	}
	
	public void addDiscount(ReceiptDiscount discount) {
		discounts.add(discount);
	}

}
