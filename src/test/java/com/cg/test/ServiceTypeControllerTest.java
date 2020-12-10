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
import com.cg.model.ServiceType;



@SpringBootTest(classes=VehicleServiceManagementApplication.class, webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ServiceTypeControllerTest {
	@Autowired
	private TestRestTemplate restTemplate;
    
	@LocalServerPort
	private int port;
	private String getRootUrl() {
		return "http://localhost:"+port;
	}
	@Test
	public void testCreateServiceType() {
		ServiceType serviceType = new ServiceType();
		serviceType.setServiceTypeName("colouring");
		ResponseEntity<String> postResponse =restTemplate.postForEntity(getRootUrl()+"/servicetype/new",serviceType,String.class);
		assertNotNull(postResponse);
		assertNotNull(postResponse.getBody());
	}
	@Test
	public void testGetAllServiceType() {
		 HttpHeaders header = new HttpHeaders();
		 HttpEntity<String> entity = new HttpEntity<String>(null, header);
		 ResponseEntity<String> response = restTemplate.exchange(getRootUrl()+"servicetype/all", HttpMethod.GET, entity, String.class);
		 System.out.println(response.getBody());
		 assertNotNull(response.getBody());
	}
	
	@Test
	public void testUpdateServiceType() {
		ServiceType serviceType = restTemplate.getForObject(getRootUrl()+"/servicetype/43", ServiceType.class);
		serviceType.setServiceTypeName("Enginer Service");
		restTemplate.put(getRootUrl()+"/servicetype/43", serviceType);
		ServiceType updateServiceType =  restTemplate.getForObject(getRootUrl()+"/servicetype/43", ServiceType.class);
	    assertNotNull(updateServiceType);
	}
	
	@Test
	public void testDeleteServiceType() {
		ServiceType serviceType = restTemplate.getForObject(getRootUrl()+"/servicetype/13", ServiceType.class);
		System.out.println(serviceType);
		restTemplate.delete(getRootUrl()+"/servicetype/13");
		ServiceType delServiceType=restTemplate.getForObject(getRootUrl()+"/servicetype/13", ServiceType.class);
		assertNotEquals(serviceType,delServiceType);
	}
	
	@Test 
	public void testGetServiceTypeByServiceTypeById() {
		ServiceType serviceType=restTemplate.getForObject(getRootUrl()+"/servicetype/102", ServiceType.class);
		System.out.println(serviceType);
		assertEquals(serviceType.getServiceTypeId(),102);
	}
	
}


