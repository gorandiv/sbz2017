package webshop.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "receipt_item_discount")
public class ReceiptItemDiscount implements Serializable {

	private static final long serialVersionUID = 3703497644841529657L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "receipt_item_discount_code")
	private String code;

	@ManyToOne
	@JsonBackReference
	private ReceiptItem item;

	@Column(name = "percentage")
	private Double percentage;

	@Column(name = "regular")
	private Boolean regular;

	public ReceiptItemDiscount() {
	}
	
	public ReceiptItemDiscount(String code, ReceiptItem item, Double percentage, Boolean regular) {
		this.code = code;
		this.item = item;
		this.percentage = percentage;
		this.regular = regular;
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

	public ReceiptItem getItem() {
		return item;
	}

	public void setItem(ReceiptItem item) {
		this.item = item;
	}

	public Double getPercentage() {
		return percentage;
	}

	public void setPercentage(Double percentage) {
		this.percentage = percentage;
	}

	public Boolean getRegular() {
		return regular;
	}

	public void setRegular(Boolean regular) {
		this.regular = regular;
	}

}
