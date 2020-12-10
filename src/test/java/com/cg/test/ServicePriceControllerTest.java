package com.cg.test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import com.cg.VehicleServiceManagementApplication;
import com.cg.model.ServicePrice;
import com.cg.vo.ServicePriceVo;


@SpringBootTest(classes=VehicleServiceManagementApplication.class, webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ServicePriceControllerTest {
	@Autowired
	private TestRestTemplate restTemplate;
    
	
	@LocalServerPort
	private int port;
	private String getRootUrl() {
		return "http://localhost:"+port;
	}
	@Test
	public void testCreateServicePrice() {
		ServicePriceVo servicePriceVo = new ServicePriceVo();
		servicePriceVo.setServiceAmount(2000);
		ResponseEntity<String> postResponse = restTemplate.postForEntity(getRootUrl()+"/serviceprice/new",servicePriceVo,String.class);
		assertNotNull(postResponse);
		assertNotNull(postResponse.getBody());

	}
	@Test
	public void testGetAllServicePrice() {
		 HttpHeaders header = new HttpHeaders();
		 HttpEntity<String> entity = new HttpEntity<String>(null, header);
		 ResponseEntity<String> response = restTemplate.exchange(getRootUrl()+"/serviceprice/all", HttpMethod.GET, entity, String.class);
		 System.out.println(response.getBody());
		 assertNotNull(response.getBody());
	}
	
	@Test
	public void testUpdateServicePrice() {
		 ServicePriceVo servicePriceVo = restTemplate.getForObject(getRootUrl()+"/serviceprice/45", ServicePriceVo.class);
		 servicePriceVo.setServiceAmount(10000);
		 restTemplate.put(getRootUrl()+"/serviceprice/45", servicePriceVo);
		 ServicePriceVo updateServicePrice =  restTemplate.getForObject(getRootUrl()+"/serviceprice/45", ServicePriceVo.class);
		 assertNotNull(updateServicePrice);
	}
	@Test
	public void testDeleteServicePrice() {
		ServicePriceVo servicePriceVo=restTemplate.getForObject(getRootUrl()+"/serviceprice/10", ServicePriceVo.class);
		restTemplate.delete(getRootUrl()+"/serviceprice/10");
		ServicePriceVo delservicePrice=restTemplate.getForObject(getRootUrl()+"/serviceprice/10", ServicePriceVo.class);
		assertNotEquals(servicePriceVo,delservicePrice);
	}
	
	  @Test 
	  public void testGetServicePriceByServicePriceId() {
		  ServicePriceVo servicePriceVo=restTemplate.getForObject(getRootUrl()+"/serviceprice/3", ServicePriceVo.class);
		  System.out.println(servicePriceVo);
		  assertEquals(servicePriceVo.getServicePriceId(),3);
	  }
	 
}
