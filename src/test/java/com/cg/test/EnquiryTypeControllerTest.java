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
import com.cg.model.EnquiryType;
import com.cg.vo.EnquiryTypeVo;

@SpringBootTest(classes=VehicleServiceManagementApplication.class, webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EnquiryTypeControllerTest {

	@Autowired
	private TestRestTemplate restTemplate;
	
	@LocalServerPort
	private int port;
	private String getRootUrl() {
		return "http://localhost:"+port;
	}
	
	/*
	 * Test case for Adding new Enquiry Type
	 */
	@Test
	public void testAddEnquiryType() {
		EnquiryTypeVo vo=new EnquiryTypeVo();
		vo.setEnquiryTypeName("huhh");
		System.out.print("new EnquiryType ="+ vo.getEnquiryTypeName());
		ResponseEntity<String> postResponse=restTemplate.postForEntity(getRootUrl()+"/enquirytype/new", vo, String.class);
		System.out.print("postresponse ="+postResponse);
		assertNotNull(postResponse);
		assertNotNull(postResponse.getBody());
	}
	
	/*
	 * Test case to get All the Enquiry Type
	 */
	@Test
	public void testGetAllEnquiryTypes() {
		HttpHeaders header=new HttpHeaders();
		HttpEntity<String> entity=new HttpEntity<String>(null,header);
		ResponseEntity<String> response=restTemplate.exchange(getRootUrl()+"/enquirytype/all",HttpMethod.GET ,entity,String.class);
		System.out.println(response.getBody());
		assertNotNull(response.getBody());
	}
	
	/*
	 * Test case to get Enquiry Type by Id
	 */
	@Test
	public void testGetEnquiryTypeById() {
		EnquiryTypeVo EnTy=restTemplate.getForObject(getRootUrl()+"/enquirytype/3", EnquiryTypeVo.class);
		System.out.println(EnTy.getEnquiryTypeId()+" "+EnTy.getEnquiryTypeName()+" ");
		assertEquals(EnTy.getEnquiryTypeId(),3);
	}
	
	/*
	 * Test case to Update Existing Enquiry Type
	 */
	@Test
	public void testUpdateEnquiryTypeById() {
		EnquiryTypeVo EnTy=restTemplate.getForObject(getRootUrl()+"/enquirytype/5", EnquiryTypeVo.class);
		assertEquals(EnTy.getEnquiryTypeId(),5);
		EnTy.setEnquiryTypeName("Updated Enquiry");
		restTemplate.put(getRootUrl()+"/enquirytype/5", EnTy);
		EnquiryType updatedEnquiryType=restTemplate.getForObject(getRootUrl()+"/enquirytype/5", EnquiryType.class);		
		assertNotNull(updatedEnquiryType);
	} 
	
	/*
	 * Test Case to delete Existing Enquiry Type
	 */
	@Test
	public void testDeleteEnquiryTypeById() {
		EnquiryTypeVo EnTy=restTemplate.getForObject(getRootUrl()+"/enquirytype/3", EnquiryTypeVo.class);
		assertEquals(EnTy.getEnquiryTypeId(),3);
		restTemplate.delete(getRootUrl()+"/enquirytype/3");
		EnquiryTypeVo delEmp=restTemplate.getForObject(getRootUrl()+"/enquirytype/3", EnquiryTypeVo.class);
		assertNotEquals(EnTy,delEmp);
	}
	
}
