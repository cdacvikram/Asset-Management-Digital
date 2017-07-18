package com.management.asset.dao;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.management.asset.model.shop.Shop;

/**
 * ShopDAO class : stores the shop details
 *  
 * @author Vikram
 */
public class ShopDAO {

	/**
	 * final shops map
	 */
	private static final Map<String, Shop> shops = new ConcurrentHashMap<>();

	/**
	 * @return the shops
	 */
	public static Map<String, Shop> getShops() {
		return shops;
	}

}
