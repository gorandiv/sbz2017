package webshop.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product implements Serializable {

	private static final long serialVersionUID = -586338449905094468L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "product_code", unique = true, nullable = false)
	private String code;

	@Column(name = "product_name")
	private String name;

	@ManyToOne
	private ProductCategory category;

	@Column(name = "prize")
	private Double prize;

	@Column(name = "quantity")
	private Integer quantity;

	@Column(name = "minimum_quantity")
	private Integer minimumQuantity;

	@Column(name = "date_noted")
	private String dateNoted;

	@Column(name = "refill_needed")
	private Boolean refillNeeded;

	@Column(name = "active")
	private Boolean active;

	@Column(name = "refill_reason")
	private String refillReason;

	@Column(name = "last_purchase_date")
	private String lastPurchaseDate;

	public Product() {
	}

	public Product(String code, String name, ProductCategory category, Double prize, Integer quantity,
			Integer minimumQuantity, String dateNoted, Boolean refillNeeded, Boolean active) {
		this.code = code;
		this.name = name;
		this.category = category;
		this.prize = prize;
		this.quantity = quantity;
		this.minimumQuantity = minimumQuantity;
		this.dateNoted = dateNoted;
		this.refillNeeded = refillNeeded;
		this.active = active;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ProductCategory getCategory() {
		return category;
	}

	public void setCategory(ProductCategory category) {
		this.category = category;
	}

	public Double getPrize() {
		return prize;
	}

	public void setPrize(Double prize) {
		this.prize = prize;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getMinimumQuantity() {
		return minimumQuantity;
	}

	public void setMinimumQuantity(Integer minimumQuantity) {
		this.minimumQuantity = minimumQuantity;
	}

	public String getDateNoted() {
		return dateNoted;
	}

	public void setDateNoted(String dateNoted) {
		this.dateNoted = dateNoted;
	}

	public Boolean getRefillNeeded() {
		return refillNeeded;
	}

	public void setRefillNeeded(Boolean refillNeeded) {
		this.refillNeeded = refillNeeded;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public String getRefillReason() {
		return refillReason;
	}

	public void setRefillReason(String refillReason) {
		this.refillReason = refillReason;
	}

	public String getLastPurchaseDate() {
		return lastPurchaseDate;
	}

	public void setLastPurchaseDate(String lastPurchaseDate) {
		this.lastPurchaseDate = lastPurchaseDate;
	}

}
