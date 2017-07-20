package com.management.asset.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.NearbySearchRequest;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;
import com.google.maps.model.PlaceType;
import com.google.maps.model.PlacesSearchResponse;
import com.google.maps.model.PlacesSearchResult;
import com.management.asset.exception.AssetMgmtException;
import com.management.asset.model.shop.Address;
import com.management.asset.model.shop.Shop;
import com.management.asset.repository.IShopRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * ShopService class to service the shop
 *  
 * @author Vikram
 */
@Service
@Slf4j
public class ShopService implements IShopService{
	
	/** the apiKey */
	@Value("${google.api.key}")
	private String apiKey;
	
	/**
	 * The shop repository
	 */
	@Autowired
	private IShopRepository repository;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Shop> getAllShops() {
		return (ArrayList<Shop>)repository.findAll(); 
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Shop getShop(String shopName) {
		return repository.findOne(shopName);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Address addShop(Shop shop) throws AssetMgmtException{
		
		GeoApiContext context = new GeoApiContext().setApiKey(apiKey);
		GeocodingResult[] results;
		try {
			results = GeocodingApi.geocode(context, shop.getShopAddress()).await();
			if( results != null && results.length > 0){
				shop.setLongitude(results[0].geometry.location.lng);
				shop.setLatitude(results[0].geometry.location.lat);
			}
		} catch (ApiException | InterruptedException | IOException e1) {
			log.error("ShopService [criticle] : Exception occures while getting the GeocodingResult");
			throw new AssetMgmtException(e1.getMessage());
		}
		
		Shop existingShop = getShop(shop.getShopName());

		Address address = new Address();
		if(existingShop !=null){
			try {
				Shop oldShop = (Shop)existingShop.clone();
				address.setCurrentAddress(shop);
				address.setPreviousAddress(oldShop);
				} catch (CloneNotSupportedException e) {
					log.error("ShopService [criticle] : CloneNotSupportedException occures while cloning the existing shop, message ({})", e.getMessage(), e);
					throw new AssetMgmtException("clone not supported");
				}
		}else
			address.setResponseMessage("new shop added");

		repository.save(shop);
		return address;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Shop nearByShop(String shopName) throws AssetMgmtException{
		Shop shop = getShop(shopName);
		GeoApiContext context = new GeoApiContext().setApiKey(apiKey);
		NearbySearchRequest nearbySearchRequest = new NearbySearchRequest(context);
		Shop nearestShop = new Shop();
		try {
			nearbySearchRequest.location(new LatLng(shop.getLatitude(), shop.getLongitude())).radius(1000);
		    nearbySearchRequest.type(PlaceType.STORE);
		    PlacesSearchResponse placesSearchResponse = nearbySearchRequest.await();
		    
		    PlacesSearchResult placesSearchResult = placesSearchResponse.results[0];
		    nearestShop.setShopName(placesSearchResult.name);
		    nearestShop.setShopAddress(placesSearchResult.vicinity);
		    nearestShop.setLatitude(placesSearchResult.geometry.location.lat);
		    nearestShop.setLongitude(placesSearchResult.geometry.location.lng);
		    
		} catch (Exception e) {
			log.error("ShopService [criticle] : Exception occures while getting the near by store, message ({})", e.getMessage(), e);
			throw new AssetMgmtException("clone not supported");
		}
		
		return nearestShop;
	}
}
