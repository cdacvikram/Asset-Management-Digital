package com.management.asset.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.management.asset.dao.ShopDAO;
import com.management.asset.model.google.GoogleGeoCode;
import com.management.asset.model.google.GoogleGeoResult;
import com.management.asset.model.shop.Address;
import com.management.asset.model.shop.Shop;

/**
 * ShopService class to service the shop
 *  
 * @author Vikram
 */
@Service
public class ShopService implements IShopService{
	
	/**
	 * the googleMapsUrl
	 */
	@Value("${google.maps.url}")
    private String googleMapsUrl;
	
	/**
	 * the apiKey
	 */
	@Value("${google.api.key}")
	private String apiKey;
	
	/**
	 * The RestTemplate
	 */
	@Autowired
	private RestTemplate restTemplate;

	/**
	 * The shop dao
	 */
	private Map<String, Shop> shops = ShopDAO.getShops();
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Shop> getAllShops() {
		return new ArrayList<Shop>(shops.values()); 
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Shop getShop(String shopName) {
		return shops.get(shopName);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Address addShop(Shop shop) {
		
		String urlShop = googleMapsUrl + shop.getShopAddress() + "&key="+apiKey;
		GoogleGeoCode googleGeoCode =  restTemplate.getForObject(urlShop, GoogleGeoCode.class);
		
		if("OK".equals(googleGeoCode.getStatus())){
			GoogleGeoResult[] results = googleGeoCode.getResults();
			GoogleGeoResult googleGeoResult = results[0];
			shop.setLongitude(googleGeoResult.getGeometry().getLocation().getLng());
			shop.setLatitude(googleGeoResult.getGeometry().getLocation().getLat());
		}
		
		Address address = new Address();
		Shop existingShop = shops.putIfAbsent(shop.getShopName(), shop);
		
		if(existingShop !=null){
			shops.put(shop.getShopName(), shop);
			address.setCurrentAddress(shop);
			address.setPreviousAddress(existingShop);
		}else
			address.setResponseMessage("new shop added");
		
		return address;
	}
}
