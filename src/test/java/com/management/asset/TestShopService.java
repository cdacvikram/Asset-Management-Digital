/*package com.management.asset;

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
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.Mock;
import org.powermock.modules.junit4.PowerMockRunner;

import com.google.maps.GeocodingApi;
import com.google.maps.GeocodingApiRequest;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.Geometry;
import com.google.maps.model.LatLng;
import com.management.asset.model.shop.Address;
import com.management.asset.model.shop.Shop;
import com.management.asset.service.ShopService;

*//**
 * TestShopService class for Shop Service
 * 
 * @author Vikram
 *//*
@RunWith(PowerMockRunner.class)
public class TestShopService {
	
	private static final Double LATITUDE = 18.5888203;
    private static final Double LONGITUDE = 73.7824641;
	
	*//**
	 * The shop service
	 *//*
	@InjectMocks
	private ShopService service;
	
	*//**
	 * The rest template
	 *//*
	@Mock
    private GeocodingApiRequest request;
	
	*//**
     * Sets up.
     *
     * @throws URISyntaxException the uri syntax exception
     * @throws IOException        the io exception
     *//*
	@Before
    public void setUp() throws Exception {

		LatLng location = new LatLng(LATITUDE, LONGITUDE);
		Geometry geometry = new Geometry();
		geometry.location = location;
		GeocodingResult geocodingResult = new GeocodingResult();
		geocodingResult.geometry = geometry;
        GeocodingResult[] geocodingResults = new GeocodingResult[] { geocodingResult };
        Mockito.when(request.latlng(location)).thenReturn(request);
        Mockito.when(request.await()).thenReturn(geocodingResults);
        PowerMockito.mockStatic(GeocodingApi.class);
        PowerMockito.when(GeocodingApi.geocode(Matchers.anyObject(), Matchers.anyString()).await()).thenReturn(geocodingResults);
        
        mockStatic(GeocodingApi.class);

        when(GeocodingApi.geocode(eq(geoApiContext)))
          .thenReturn(geocodingApiRequest);
        
//		Mockito.when((GeocodingApi.geocode(Matchers.anyObject(), Matchers.anyString())).thenReturn(request);
		
	}
	
	*//**
     * Test single add shop
     *
     * @throws Exception the exception
     *//*
	@Test
	public void testAddShop() throws Exception{
		
		Shop shop = new Shop();
		shop.setShopName("shopone");
		shop.setShopAddress("CopaCabana,Omka, Pimple Nilakh, Pimpri-Chinchwad, Maharashtra");
		shop.setShopPostCode("12345");
		Mockito.verify(GeocodingApi.geocode(Matchers.anyObject(), Matchers.anyString()));
		Address address = service.addShop(shop);
		Shop shop2 = service.getShop("shopone");
        assertEquals("18.585582", shop2.getLatitude());
        assertEquals("73.781668", shop2.getLongitude());
        assertNull(address.getCurrentAddress());
		assertNull(address.getPreviousAddress());
	}
	
	*//**
     * Test add shop with duplicate shop name
     *
     * @throws Exception the exception
     *//*
	@Test
	public void testAddDuplicateShop() throws Exception{
		
		Shop shop = new Shop();
		shop.setShopName("shoptwo");
		shop.setShopAddress("Mother's Kitchen, Vishal Nagar, Pimpri-Chinchwad, Maharashtra");
		shop.setShopPostCode("411038");
		Mockito.verify(GeocodingApi.geocode(Matchers.anyObject(), Matchers.anyString()));
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
*/