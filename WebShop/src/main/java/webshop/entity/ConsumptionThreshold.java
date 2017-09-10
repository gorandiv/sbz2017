package webshop.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "consumption_threshold")
public class ConsumptionThreshold implements Serializable {

	private static final long serialVersionUID = -7124968878378140529L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "range_from")
	private Double rangeFrom;

	@Column(name = "range_to")
	private Double rangeTo;

	@Enumerated(EnumType.STRING)
	@Column(name = "calculus_function")
	private CalculusFunction calculusFunction;

	public ConsumptionThreshold() {
	}

	public ConsumptionThreshold(Double rangeFrom, Double rangeTo, CalculusFunction calculusFunction) {
		this.rangeFrom = rangeFrom;
		this.rangeTo = rangeTo;
		this.calculusFunction = calculusFunction;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getRangeFrom() {
		return rangeFrom;
	}

	public void setRangeFrom(Double rangeFrom) {
		this.rangeFrom = rangeFrom;
	}

	public Double getRangeTo() {
		return rangeTo;
	}

	public void setRangeTo(Double rangeTo) {
		this.rangeTo = rangeTo;
	}

	public CalculusFunction getCalculusFunction() {
		return calculusFunction;
	}

	public void setCalculusFunction(CalculusFunction calculusFunction) {
		this.calculusFunction = calculusFunction;
	}

}
