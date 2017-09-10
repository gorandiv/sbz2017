package webshop.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "action_sale")
public class ActionSale implements Serializable {

	private static final long serialVersionUID = -4270582046951325388L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "action_sale_code")
	private String code;

	@Column(name = "action_sale_name")
	private String name;

	@Column(name = "start_date")
	private String startDate;

	@Column(name = "end_date")
	private String endDate;

	@Column(name = "discount_percentage")
	private Double discountPercentage;

	@ManyToMany
	private List<ProductCategory> productCategories;

	public ActionSale() {
	}

	public ActionSale(String code, String name, String startDate, String endDate, Double discountPercentage) {
		this.code = code;
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.discountPercentage = discountPercentage;
	}

	public ActionSale(String code, String name, String startDate, String endDate, Double discountPercentage,
			List<ProductCategory> productCategories) {
		this.code = code;
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.discountPercentage = discountPercentage;
		this.productCategories = productCategories;
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

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public Double getDiscountPercentage() {
		return discountPercentage;
	}

	public void setDiscountPercentage(Double discountPercentage) {
		this.discountPercentage = discountPercentage;
	}

	public List<ProductCategory> getProductCategories() {
		return productCategories;
	}

	public void setProductCategories(List<ProductCategory> productCategories) {
		this.productCategories = productCategories;
	}

}
