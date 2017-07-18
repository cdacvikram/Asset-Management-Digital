package com.management.asset.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * AppConfig class configures all other beans
 * 
 * @author Vikram
 *
 */
@Configuration
public class AppConfig {
	
	/**
	 * RestTemplate bean
	 * @return RestTemplate
	 */
	@Bean
	public RestTemplate restTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate;
	}

}
