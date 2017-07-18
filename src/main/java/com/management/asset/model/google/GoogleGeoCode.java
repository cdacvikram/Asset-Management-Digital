package com.management.asset.model.google;

import lombok.Data;

/**
 * GoogleGeoCode class
 * 
 * @author Vikram
 */
@Data
public class GoogleGeoCode {
	
	/** Properties **/
	private String status;
    private GoogleGeoResult [] results;
    private Boolean exclude_from_slo;
    private String error_message;
	
}
