package com.management.asset.model.google;

import lombok.Data;

/**
 * GoogleGeoAdressComponent class
 * 
 * @author Vikram
 */
@Data
public class GoogleGeoAdressComponent {
	
	/** Properties **/
	private String long_name;
    private String short_name;
    private String [] types;    
}
