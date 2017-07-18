package com.management.asset.model.google;

import lombok.Data;

/**
 * GoogleGeoGeometry class
 * 
 * @author Vikram
 */
@Data
public class GoogleGeoGeometry {
	
	/** Properties **/
	private GoogleGeoBounds bounds;
    private GoogleGeoLatLng location;
    private String location_type;
    private GoogleGeoBounds viewport;
    
}
