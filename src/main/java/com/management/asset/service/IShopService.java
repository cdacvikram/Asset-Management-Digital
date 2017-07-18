package com.management.asset.service;

import java.util.List;

import com.management.asset.model.shop.Address;
import com.management.asset.model.shop.Shop;

/**
 * Interface IShopService
 * 
 * @author Vikram
 */
public interface IShopService {
	

	/**
	 * gets all shops
	 * @return List<Shop> 
	 */
	List<Shop> getAllShops();
	
	/**
	 * gets a shop
	 * @return Shop 
	 */
	Shop getShop(String shopName);
	
	/**
	 * gets the added shop
	 * @return Address
	 */
	Address addShop(Shop shop);
}
