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
@Table(name = "receipt_discount")
public class ReceiptDiscount implements Serializable {

	private static final long serialVersionUID = -40484793012308411L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "receipt_discount_code")
	private String code;

	@ManyToOne
	@JsonBackReference
	private Receipt receipt;

	@Column(name = "percentage")
	private Double percentage;

	@Column(name = "regular")
	private Boolean regular;

	public ReceiptDiscount() {
	}

	public ReceiptDiscount(String code, Receipt receipt, Double percentage, Boolean regular) {
		this.code = code;
		this.receipt = receipt;
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

	public Receipt getReceipt() {
		return receipt;
	}

	public void setReceipt(Receipt receipt) {
		this.receipt = receipt;
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
