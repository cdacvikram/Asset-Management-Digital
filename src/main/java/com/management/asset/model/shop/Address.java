package com.management.asset.model.shop;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * Address class
 * 
 * @author Vikram
 */
@Data
public class Address {
	
	/** Properties **/
	@JsonProperty("CurrentAddress")
	@JsonInclude(JsonInclude.Include.NON_NULL) 
	private Shop currentAddress;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("PreviousAddress")
	private Shop previousAddress;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String responseMessage;

}
