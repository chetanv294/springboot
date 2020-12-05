 
package  net.spring.auction;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author  
 */
@Entity
public class AuctionInfo {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private int id;
	
	@Column(name = "description",  length = 100)
	private String description;
	
	@Column(name = "ends" )
	private Date ends;
	@Column(name = "amount" )
	private Float maxAmount;
	
public 	AuctionInfo(){};
	public String getDescription() {
		return description;
	}

	
	public Date getEnds() {
		return ends;
	}

	public int getId() {
		return id;
	}

	public Float getMaxAmount() {
		return maxAmount;
	}
	
	public AuctionInfo(int id, String description, Date ends, Float maxAmount) {
		this.id = id;
		this.description = description;
		this.ends = ends;
		this.maxAmount = maxAmount;
	}

}
