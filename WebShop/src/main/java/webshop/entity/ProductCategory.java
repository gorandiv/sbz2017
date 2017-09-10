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
@Table(name = "product_category")
public class ProductCategory implements Serializable {

	private static final long serialVersionUID = 3085738441068189175L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "product_category_code", unique = true, nullable = false)
	private String code;

	@ManyToOne(optional = true)
	private ProductCategory parentCategory;

	@Column(name = "product_category_name")
	private String name;

	@Column(name = "maximum_discount")
	private Integer maximumDiscount;

	@Column(name = "last_purchase_date")
	private String lastPurchaseDate;

	public ProductCategory() {
	}

	public ProductCategory(String code, ProductCategory parentCategory, String name, Integer maximumDiscount) {
		this.code = code;
		this.parentCategory = parentCategory;
		this.name = name;
		this.maximumDiscount = maximumDiscount;
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

	public ProductCategory getParentCategory() {
		return parentCategory;
	}

	public void setParentCategory(ProductCategory parentCategory) {
		this.parentCategory = parentCategory;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getMaximumDiscount() {
		return maximumDiscount;
	}

	public void setMaximumDiscount(Integer maximumDiscount) {
		this.maximumDiscount = maximumDiscount;
	}

	public String getLastPurchaseDate() {
		return lastPurchaseDate;
	}

	public void setLastPurchaseDate(String lastPurchaseDate) {
		this.lastPurchaseDate = lastPurchaseDate;
	}

}
