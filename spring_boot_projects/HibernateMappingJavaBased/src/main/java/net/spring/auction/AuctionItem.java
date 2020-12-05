package net.spring.auction;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author chetan
 */
@Entity
@Table(name = "Auctionitem")
public class AuctionItem implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
   
    public  AuctionItem(){};
	 
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private int id;
	
	@Column(name = "description",  length = 100)
	private String description;
	
	@Column(name = "shortdescription",  length = 50)
	private String shortDescription;
	
	@OneToMany(
    		mappedBy = "item",
            targetEntity=net.spring.auction.Bid.class,
            cascade={CascadeType.ALL})
	private List bids;
	
	// private Bid successfulBid;
	
	@ManyToOne
	@JoinColumn(name = "sellerid", nullable = false)
	private User seller;
	
	@Column(name = "ends")
	private Date ends;
	
	@Column(name = "conditions")
	private int condition;
	
	public List getBids() {
		return bids;
	}

	public String getDescription() {
		return description;
	}

	public User getSeller() {
		return seller;
	}
public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	/*
	public Bid getSuccessfulBid() {
		return successfulBid;
	}
	public void setSuccessfulBid(Bid bid) {
		successfulBid = bid;
	} */
	public void setBids(List bids) {
		this.bids = bids;
	}

	public void setDescription(String string) {
		description = string;
	}

	public void setSeller(User user) {
		seller = user;
	}

	

	public Date getEnds() {
		return ends;
	}

	public void setEnds(Date date) {
		ends = date;
	}
	
	public int getCondition() {
		return condition;
	}

	public void setCondition(int i) {
		condition = i;
	}

	public String toString() {
		return shortDescription + " (" + description + ": " + condition + "/10)";
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}
	
	public AuctionItem(int id, String description, Date ends, Float maxAmount) {
		this.id = id;
		this.description = description;
		this.ends = ends;
		//this.maxAmount = maxAmount;
	}

}
