package com.management.asset.model.google;

import lombok.Data;

/**
 * GoogleGeoResult class
 * 
 * @author Vikram
 */
@Data
public class GoogleGeoResult {
	
	/** Properties **/
	private GoogleGeoAdressComponent [] address_components;
    private String formatted_address;
    private GoogleGeoGeometry geometry;
    private Boolean partial_match;
    private String place_id;
    private String [] types;
	
}
