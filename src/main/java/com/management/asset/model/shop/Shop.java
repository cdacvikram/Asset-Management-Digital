package com.management.asset.model.shop;

import lombok.Data;

/**
 * Shop class
 * 
 * @author Vikram
 */
@Data
public class Shop {
	
	/** Properties **/
	private String shopName;
	private String shopAddress;
	private String shopPostCode;
	private String latitude;
	private String longitude;
	
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

}
