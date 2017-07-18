package com.management.asset;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

import com.management.asset.model.google.GoogleGeoCode;
import com.management.asset.model.google.GoogleGeoGeometry;
import com.management.asset.model.google.GoogleGeoLatLng;
import com.management.asset.model.google.GoogleGeoResult;
import com.management.asset.model.shop.Address;
import com.management.asset.model.shop.Shop;
import com.management.asset.service.ShopService;

/**
 * TestShopService class for Shop Service
 * 
 * @author Vikram
 */
@RunWith(MockitoJUnitRunner.class)
public class TestShopService {
	
	/**
	 * The shop service
	 */
	@InjectMocks
	private ShopService service;
	
	/**
	 * The rest template
	 */
	@Mock
    private RestTemplate restTemplate;
	
	/**
     * Sets up.
     *
     * @throws URISyntaxException the uri syntax exception
     * @throws IOException        the io exception
     */
	@Before
    public void setUp() throws URISyntaxException, IOException {
		
		GoogleGeoLatLng  location = new GoogleGeoLatLng();
		GoogleGeoGeometry geometry = new GoogleGeoGeometry();
		GoogleGeoResult [] results = new GoogleGeoResult[1];
		GoogleGeoResult googleGeoResult = new GoogleGeoResult();
		GoogleGeoCode googleGeoCode  = new GoogleGeoCode();
		geometry.setLocation(location);
		googleGeoResult.setGeometry(geometry);
		results[0] = googleGeoResult;
		googleGeoCode.setResults(results);
	
		
		googleGeoCode.getResults()[0].getGeometry().getLocation().setLat("18.585582");
		googleGeoCode.getResults()[0].getGeometry().getLocation().setLng("73.781668");
		googleGeoCode.setStatus("OK");
	
        Mockito.when(restTemplate.getForObject(Matchers.anyString(), Matchers.anyObject())).thenReturn(googleGeoCode);
		
	}
	
	/**
     * Test single add shop
     *
     * @throws Exception the exception
     */
	@Test
	public void testAddShop() throws Exception{
		
		Shop shop = new Shop();
		shop.setShopName("shopone");
		shop.setShopAddress("CopaCabana,Omka, Pimple Nilakh, Pimpri-Chinchwad, Maharashtra");
		shop.setShopPostCode("12345");
		Mockito.verify(restTemplate, Mockito.times(0)).getForObject(Matchers.anyString(), Matchers.eq(GoogleGeoCode.class));
		Address address = service.addShop(shop);
		Shop shop2 = service.getShop("shopone");
        assertEquals("18.585582", shop2.getLatitude());
        assertEquals("73.781668", shop2.getLongitude());
        assertNull(address.getCurrentAddress());
		assertNull(address.getPreviousAddress());
	}
	
	/**
     * Test add shop with duplicate shop name
     *
     * @throws Exception the exception
     */
	@Test
	public void testAddDuplicateShop() throws Exception{
		
		Shop shop = new Shop();
		shop.setShopName("shoptwo");
		shop.setShopAddress("Mother's Kitchen, Vishal Nagar, Pimpri-Chinchwad, Maharashtra");
		shop.setShopPostCode("411038");
		Mockito.verify(restTemplate, Mockito.times(0)).getForObject(Matchers.anyString(), Matchers.eq(GoogleGeoCode.class));
		Address address = service.addShop(shop);
		Shop shop2 = service.getShop("shoptwo");
        assertEquals("18.585582", shop2.getLatitude());
        assertEquals("73.781668", shop2.getLongitude());
        assertNull(address.getCurrentAddress());
		assertNull(address.getPreviousAddress());
		
		Shop shop3 = new Shop();
		shop3.setShopName("shoptwo");
		shop3.setShopAddress("Mother's Kitchen, Vishal Nagar, Pimpri-Chinchwad, Maharashtra");
		shop3.setShopPostCode("422038");
		Address address2 = service.addShop(shop3);
		assertNotNull(address2.getCurrentAddress());
		assertNotNull(address2.getPreviousAddress());
        assertEquals("18.585582", address2.getCurrentAddress().getLatitude());
        assertEquals("73.781668", address2.getCurrentAddress().getLongitude());
        assertEquals("422038", address2.getCurrentAddress().getShopPostCode());
	}

}
