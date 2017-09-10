package webshop.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "buyer_profile")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Profile implements Serializable {

	private static final long serialVersionUID = 4959686697215881224L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "delivery_address")
	private String deliveryAddress;

	@Column(name = "reward_points")
	private Integer rewardPoints;

	@ManyToOne
	private BuyerCategory category;

	@OneToMany(fetch = FetchType.EAGER)
	@JsonManagedReference
	private Set<Receipt> realizedReceipts;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="buyer_id")
	private Buyer buyer;

	public Profile() {
	}

	public Profile(String deliveryAddress, Integer rewardPoints, BuyerCategory category, Buyer buyer) {
		this.deliveryAddress = deliveryAddress;
		this.rewardPoints = rewardPoints;
		this.category = category;
		this.buyer = buyer;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public Integer getRewardPoints() {
		return rewardPoints;
	}

	public void setRewardPoints(Integer rewardPoints) {
		this.rewardPoints = rewardPoints;
	}

	public BuyerCategory getCategory() {
		return category;
	}

	public void setCategory(BuyerCategory category) {
		this.category = category;
	}

	public Set<Receipt> getRealizedReceipts() {
		return realizedReceipts;
	}

	public void setRealizedReceipts(Set<Receipt> realizedReceipts) {
		this.realizedReceipts = realizedReceipts;
	}

	public Buyer getBuyer() {
		return buyer;
	}

	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
	}
	
	public void addRealizedReceipt(Receipt receipt) {
		realizedReceipts.add(receipt);
	}

}
