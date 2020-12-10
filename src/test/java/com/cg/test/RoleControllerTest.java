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
import com.cg.model.Role;
import com.cg.vo.RoleVo;

@SpringBootTest(classes=VehicleServiceManagementApplication.class, webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RoleControllerTest {
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@LocalServerPort
	private int port;
	private String getRootUrl() {
		return "http://localhost:"+port;
	}
	
	/*
	 * This method testing for the creation of entity in Role table
	 */
	@Test
	public void testCreateRole() {
		RoleVo rol=new RoleVo();
		rol.setRoleName("Usehsdffffffffffffffffffffffffffffg");
		ResponseEntity<String> postResponse=restTemplate.postForEntity(getRootUrl()+"/role/newrole", rol, String.class);
		System.out.print("postresponse ="+postResponse);
		assertNotNull(postResponse);
		assertNotNull(postResponse.getBody());
	}
	
	/*
	 * This method is for testing the return of all entity in Role table
	 */
	@Test
	public void testGetAllRoles() {
		HttpHeaders header=new HttpHeaders();
		HttpEntity<String> entity=new HttpEntity<String>(null,header);
		ResponseEntity<String> response=restTemplate.exchange(getRootUrl()+"/role/all",HttpMethod.GET ,entity,String.class);
		System.out.println(response.getBody());
		assertNotNull(response.getBody());
	}
	
	/*
	 * This method testing for the updating of entity in Role table
	 */
	@Test
	public void testUpdateRole() {
		RoleVo rol=restTemplate.getForObject(getRootUrl()+"/role/6", RoleVo.class);
		assertEquals(rol.getRoleId(),6);
		rol.setRoleName("Admin");
		restTemplate.put(getRootUrl()+"/role/6", rol);
		RoleVo updatedRole=restTemplate.getForObject(getRootUrl()+"/role/6", RoleVo.class);		
		assertNotNull(updatedRole);
	}

	/*
	 * This method testing for the deleting of entity in Role table
	 */
	@Test
	public void testDeleteRole() {
		RoleVo rol=restTemplate.getForObject(getRootUrl()+"/role/5", RoleVo.class);
		assertEquals(rol.getRoleId(),5);
		restTemplate.delete(getRootUrl()+"/role/5");
		RoleVo delrol=restTemplate.getForObject(getRootUrl()+"/role/5", RoleVo.class);
		assertNotEquals(rol,delrol);
	}
	
	/*
	 * This method is for testing the return of RoleId from Role table
	 */
	@Test
	public void testGetRoleById() {
		RoleVo rol=restTemplate.getForObject(getRootUrl()+"/role/6", RoleVo.class);
		System.out.println(rol.getRoleName()+" "+rol.getRoleId());
		assertEquals(rol.getRoleId(),6);
	
	}

}
	
	
