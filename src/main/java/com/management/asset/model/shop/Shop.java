package com.management.asset.model.shop;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * Shop class
 * 
 * @author Vikram
 */
@Data
@Entity
@Table(name="shop")
public class Shop implements Serializable, Cloneable {
	
	/** Default serial Version UID */
	private static final long serialVersionUID = 1L;

	/** Properties **/
	@Id
	@Column(name="shop_name")
	private String shopName;
	
	@Column(name="shop_address")
	private String shopAddress;
	
	@Column(name="shop_postcode")
	private String shopPostCode;
	
	@Column(name="latitude")
	private double latitude;
	
	@Column(name="longitude")
	private double longitude;
	
	/**
	 * default constructor
	 */
	public Shop() {}
	
	/**
	 * Parameterized constructor
	 * 
	 * @param shopName
	 * @param shopAddress
	 * @param shopPostCode
	 */
	public Shop(String shopName, String shopAddress, String shopPostCode) {
		super();
		this.shopName = shopName;
		this.shopAddress = shopAddress;
		this.shopPostCode = shopPostCode;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Shop [shopName=" + shopName + ", shopAddress=" + shopAddress + ", shopPostCode=" + shopPostCode
				+ ", latitude=" + latitude + ", longitude=" + longitude + "]";
	}

	public Object clone()throws CloneNotSupportedException{  
		return super.clone();  
	}
}
