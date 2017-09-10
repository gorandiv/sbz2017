package webshop.entity;

import java.io.Serializable;

public class ProductSearch implements Serializable {

	private static final long serialVersionUID = 3033827310393546968L;

	private String code;
	private String name;
	private Integer categoryId;
	private Double from;
	private Double to;

	public ProductSearch() {
	}

	public ProductSearch(String code, String name, Integer categoryId, Double from, Double to) {
		this.code = code;
		this.name = name;
		this.categoryId = categoryId;
		this.from = from;
		this.to = to;
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

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public Double getFrom() {
		return from;
	}

	public void setFrom(Double from) {
		this.from = from;
	}

	public Double getTo() {
		return to;
	}

	public void setTo(Double to) {
		this.to = to;
	}

}
