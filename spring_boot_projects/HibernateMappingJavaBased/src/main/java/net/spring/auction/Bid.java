package net.spring.auction;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author chetan
 */
@Entity
@Table(name = "Auctionbid")
public class Bid implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
	
	 
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private int id;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@ManyToOne
	@JoinColumn(name = "auction_item_id", nullable = false)
	private AuctionItem item;
	
	@Column(name = "amount")
	private float amount;
	
	@Column(name = "datetime")
	private Date datetime;
	
	@ManyToOne
	@JoinColumn(name = "userid", nullable = false)
	private User bidder;
	
	public AuctionItem getItem() {
		return item;
	}

	public void setItem(AuctionItem item) {
		this.item = item;
	}

	public float getAmount() {
		return amount;
	}

	public Date getDatetime() {
		return datetime;
	}

	public void setAmount(float f) {
		amount = f;
	}

	public void setDatetime(Date date) {
		datetime = date;
	}

	public User getBidder() {
		return bidder;
	}

	public void setBidder(User user) {
		bidder = user;
	}

	public String toString() {
		return bidder.getUserName() + " $" + amount;
	}
	
	public boolean isBuyNow() {
		return false;
	}

}
