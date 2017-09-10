package webshop.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "buyer_category")
public class BuyerCategory implements Serializable {

	private static final long serialVersionUID = -916144316947697386L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "buyer_category_code")
	private String code;

	@Column(name = "buyer_category_name")
	private String name;

	@ManyToMany(fetch = FetchType.EAGER)
	private List<ConsumptionThreshold> consumptionThresholds;

	public BuyerCategory() {
	}

	public BuyerCategory(String code, String name) {
		this.code = code;
		this.name = name;
	}

	public BuyerCategory(String code, String name, List<ConsumptionThreshold> consumptionThresholds) {
		this.code = code;
		this.name = name;
		this.consumptionThresholds = consumptionThresholds;
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

	public List<ConsumptionThreshold> getConsumptionThresholds() {
		return consumptionThresholds;
	}

	public void setConsumptionThresholds(List<ConsumptionThreshold> consumptionThresholds) {
		this.consumptionThresholds = consumptionThresholds;
	}

}
