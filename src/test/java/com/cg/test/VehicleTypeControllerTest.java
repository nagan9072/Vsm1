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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;

import com.cg.VehicleServiceManagementApplication;
import com.cg.model.VehicleType;
import com.cg.vo.VehicleTypeVo;

@SpringBootTest(classes=VehicleServiceManagementApplication.class, webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
public class VehicleTypeControllerTest {
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@LocalServerPort
	private int port;
	private String getRootUrl() {
		return "http://localhost:"+port;
	}
	
	/*
	 * This method testing for the creation of entity in VehicleType table
	 */
	@Test
	public void testCreateVehicleType() {
		VehicleTypeVo vehicle=new VehicleTypeVo(); 
		vehicle.setVehicleTypeName("12 Wheeler");
		ResponseEntity<String> postResponse=restTemplate.postForEntity(getRootUrl()+"/vehicletype/newvehicle", vehicle, String.class);
		assertNotNull(postResponse);
		assertNotNull(postResponse.getBody());
	}
	
	/*
	 * This method is for testing the return of all entity in VehicletType table
	 */
	@Test
	public void testGetAllVechicleType() {
		HttpHeaders header=new HttpHeaders();
		HttpEntity<String> entity=new HttpEntity<String>(null,header);
		ResponseEntity<String> response=restTemplate.exchange(getRootUrl()+"/vehicletype/all",HttpMethod.GET ,entity,String.class);
		System.out.println(response.getBody());
		assertNotNull(response.getBody());
	}
	/*
	 * This method testing for the updating of entity in VehicletType table
	 */
	@Test
	public void testUpdateVehicleType() {
		VehicleTypeVo vehicle=restTemplate.getForObject(getRootUrl()+"/vehicletype/34", VehicleTypeVo.class);
		assertEquals(vehicle.getVehicleTypeId(),34);
		vehicle.setVehicleTypeName("3 Wheeler");
		restTemplate.put(getRootUrl()+"/vehicletype/34", vehicle);
		VehicleTypeVo updatedVehicleType=restTemplate.getForObject(getRootUrl()+"/vehicletype/34", VehicleTypeVo.class);		
		assertNotNull(updatedVehicleType);
	}
	
	/*
	 * This method testing for the deleting of entity in VehicletType table
	 */
	@Test
	public void testDeleteVehicleType() {
		VehicleTypeVo vehicle=restTemplate.getForObject(getRootUrl()+"/vehicletype/35", VehicleTypeVo.class);
		assertEquals(vehicle.getVehicleTypeId(),35);
		restTemplate.delete(getRootUrl()+"/vehicletype/35");
		VehicleTypeVo delvehicle=restTemplate.getForObject(getRootUrl()+"/vehicletype/35", VehicleTypeVo.class);
		assertNotEquals(vehicle,delvehicle);
	}
	
	/*
	 * This method is for testing the return of RoleId from VehicletType table
	 */
	@Test
	public void testGetVehicleTypeById() {
		VehicleTypeVo vehicle=restTemplate.getForObject(getRootUrl()+"/vehicletype/34", VehicleTypeVo.class);
		//System.out.println(vehicle.getVehicleTypeName()+" "+vehicle.getVehicleTypeId());
		assertEquals(vehicle.getVehicleTypeId(),34);
	
	
	}
	
}