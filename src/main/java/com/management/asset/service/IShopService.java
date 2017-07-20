package com.management.asset.service;

import java.util.List;

import com.management.asset.exception.AssetMgmtException;
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
	 * 
	 * @return Shop 
	 */
	Shop getShop(String shopName);
	
	/**
	 * gets the added shop
	 * @return Address
	 * @throws AssetMgmtException
	 */
	Address addShop(Shop shop) throws AssetMgmtException;
	
	/**
	 * gets a near by store
	 * 
	 * @param shopName
	 * @return Shop
	 */
	Shop nearByShop(String shopName)  throws AssetMgmtException;
}
