package net.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "productt_talbe")
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "proid")
	private int productId;
	
	@Column(name = "proName", length = 10)
	private String proName;
	
	@Column(name = "price")
	private double price;
	
	

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}

	public String getProName() {
		return proName;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getPrice() {
		return price;
	}
}
