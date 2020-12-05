
package net.spring.auction;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author chetan
 */

@Entity
@Table(name = "Auctionuser")
public class User implements java.io.Serializable {
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

	@Column(name = "username",  length = 20)
	private String userName;
	@Column(name = "password",  length = 20)
	private String password;
	@Column(name = "email",  length = 20)
	private String email;
	
//	private Name name;
	@Column(name = "firstname",  length = 20)
	private String firstName;
	 
	@Column(name = "lastname",  length = 20)
	private String lastName;
	@Column(name = "initial")
	private Character initial;
	
	@OneToMany(
    		mappedBy = "bidder",
            targetEntity=net.spring.auction.Bid.class,
            cascade={CascadeType.ALL})
	private List bids;
	
	@OneToMany(
    		mappedBy = "seller",
            targetEntity=net.spring.auction.AuctionItem.class,
            cascade={CascadeType.ALL})
	private List auctions;
	
	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getUserName() {
		return userName;
	}

	public void setEmail(String string) {
		email = string;
	}

	public void setPassword(String string) {
		password = string;
	}

	public void setUserName(String string) {
		userName = string;
	}

	public List getAuctions() {
		return auctions;
	}

	public List getBids() {
		return bids;
	}

	public void setAuctions(List list) {
		auctions = list;
	}

	public void setBids(List list) {
		bids = list;
	}
	
	public String toString() {
		return userName;
	}
/*
	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}
	*/
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Character getInitial() {
		return initial;
	}

	public void setInitial(Character initial) {
		this.initial = initial;
	}

}
