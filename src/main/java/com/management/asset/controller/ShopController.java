package com.management.asset.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.management.asset.model.shop.Address;
import com.management.asset.model.shop.Shop;
import com.management.asset.service.IShopService;

import io.swagger.annotations.ApiOperation;

/**
 * ShopController class : controllor for shop details
 *  
 * @author Vikram
 */
@RestController
public class ShopController {
	
	/**
	 * The shop service
	 */
	@Autowired
	private IShopService service;
	
	/**
	 * Method gets all shops
	 * @return  List<Shop>
	 */
	@ApiOperation(value = "Getting all Shops")
	@GetMapping("/shops")
	public List<Shop> getAllShops(){
		return service.getAllShops();
	}
	
	/**
	 * Method gets a shop details
	 * @param ShopName
	 * @return Shop
	 */
	@ApiOperation(value = "Getting a Shop via id")
	@GetMapping("/shops/{id}")
	public Shop getShop(@PathVariable String ShopName ){
		return service.getShop(ShopName);
	}
	
	/**
	 * Method adds a shop
	 * 
	 * @param shop
	 * @return Address
	 */
	@ApiOperation(value = "Adding a Shop ")
	@PostMapping("/shops")
	public Address addShop(@RequestBody Shop shop){
		return service.addShop(shop);
	}

}
