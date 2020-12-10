package com.cg.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Date;

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
import com.cg.model.Services;
import com.cg.vo.ServiceVo;

@SpringBootTest(classes=VehicleServiceManagementApplication.class, webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ServiceControllerTest {

	@Autowired
	private TestRestTemplate restTemplate;
	
	@LocalServerPort
	private int port;
	private String getRootUrl() {
		return "http://localhost:"+port;
	}
	
	@Test
	public void testCreateService() {
		Date date=new Date();
		ServiceVo vo=new ServiceVo();
		vo.setVehicleBrand("Honda");
		vo.setVehicleRegno("TN09 k9898");
		vo.setAdminStatus("Completed");
		vo.setServiceRequestDate(date);
		vo.setDeliveryDate(date);
		
		ResponseEntity<String> postResponse=restTemplate.postForEntity(getRootUrl()+"/service/new", vo, String.class);
		assertNotNull(postResponse);
		assertNotNull(postResponse.getBody());
	}
	
	@Test
	public void testGetAllServices() {
		HttpHeaders header=new HttpHeaders();
		HttpEntity<String> entity=new HttpEntity<String>(null,header);
		ResponseEntity<String> response=restTemplate.exchange(getRootUrl()+"/service/all",HttpMethod.GET ,entity,String.class);
		System.out.println(response.getBody());
		assertNotNull(response.getBody());
	}
	
	@Test
	public void testGetServiceById() {
		ServiceVo service=restTemplate.getForObject(getRootUrl()+"/service/7", ServiceVo.class);
		System.out.println(service.getVehicleBrand()+" "+service.getVehicleRegno()+" "+service.getServiceId());
		assertEquals(service.getServiceId(),7);
	}
	
	@Test
	public void testUpdateEmployee() {
		ServiceVo service=restTemplate.getForObject(getRootUrl()+"/service/2", ServiceVo.class);
		assertEquals(service.getServiceId(),2);
		service.setVehicleBrand("Honda");
		service.setVehicleRegno("TN09 K9898");
		restTemplate.put(getRootUrl()+"/service/2", service);
		Services updatedEmployee=restTemplate.getForObject(getRootUrl()+"/service/2", Services.class);		
		assertNotNull(updatedEmployee);
	} 
	
	@Test
	public void getServiceByAdminStatus() {
		HttpHeaders header=new HttpHeaders();
		HttpEntity<String> entity=new HttpEntity<String>(null,header);
		ResponseEntity<String> response=restTemplate.exchange(getRootUrl()+"/service/status/NotCompleted",HttpMethod.GET ,entity,String.class);
		System.out.println(response.getBody());
		assertNotNull(response.getBody());	
	}
	
	@Test
	public void testDeleteEmployee() {
		ServiceVo service=restTemplate.getForObject(getRootUrl()+"/service/28", ServiceVo.class);
		assertEquals(service.getServiceId(),28);
		restTemplate.delete(getRootUrl()+"/service/28");
		ServiceVo delEmp=restTemplate.getForObject(getRootUrl()+"/service/28", ServiceVo.class);
		assertNotEquals(service,delEmp);
	}
	
}
