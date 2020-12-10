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
import com.cg.model.Mechanics;
import com.cg.vo.MechanicsVo;

@SpringBootTest(classes=VehicleServiceManagementApplication.class, webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MechanicsControllerTest {
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@LocalServerPort
	private int port;
	private String getRootUrl() {
		return "http://localhost:"+port;
	}
	
	
	  @Test 
	  public void testCreateMechanics() { 
	  MechanicsVo mech=new MechanicsVo();
	  mech.setFirstName("ap"); mech.setLastName("v");
	  mech.setMobileNumber("7200845082"); mech.setEmail("vacvsv@gmaul.com");
	  mech.setAddress("bengaluru");
	  System.out.print("new mehcnic ="+ mech.getFirstName());
	  //ResponseEntity<MechanicsVo> postResponse=restTemplate.postForEntity(getRootUrl()+"/mechanics/newmech",mech, MechanicsVo.class);
	  ResponseEntity<String> postResponse=restTemplate.postForEntity(getRootUrl()+"/mechanics/newmech",mech, String.class);
	  System.out.print("postresponse ="+postResponse);
	  assertNotNull(postResponse);
	  assertNotNull(postResponse.getBody()); 
	  }
	 
	
	@Test
	public void testGetAllMechanicss() {
		HttpHeaders header=new HttpHeaders();
		HttpEntity<String> entity=new HttpEntity<String>(null,header);
		ResponseEntity<String> response=restTemplate.exchange(getRootUrl()+"/mechanics/all",HttpMethod.GET ,entity,String.class);
		System.out.println(response.getBody());
		assertNotNull(response.getBody());
	}
	
	@Test
	public void testGetMechanicsById() {
		MechanicsVo mechvo=restTemplate.getForObject(getRootUrl()+"/mechanics/30", MechanicsVo.class);
		System.out.println(mechvo.getFirstName()+ " "+mechvo.getLastName()+" "+mechvo.getId()+" "+mechvo.getAddress()+" "+mechvo.getMobileNumber()+" "+mechvo.getEmail());
		assertNotNull(mechvo);
	}
	@Test
	public void testGetMechanicByNumber() {
		HttpHeaders header=new HttpHeaders();
		HttpEntity<String> entity=new HttpEntity<String>(null,header);
		ResponseEntity<String> response=restTemplate.exchange(getRootUrl()+"/mechanics/number/7200845081",HttpMethod.GET ,entity,String.class);
		System.out.println(response.getBody());
		assertNotNull(response.getBody());
	}
	
	@Test
	public void testUpdateMechanics() {
		MechanicsVo mechvo=restTemplate.getForObject(getRootUrl()+"/mechanics/30", MechanicsVo.class);
		
		mechvo.setAddress("canada");
		restTemplate.put(getRootUrl()+"/mechanics/30", mechvo);
		Mechanics updatedMechanics=restTemplate.getForObject(getRootUrl()+"/mechanics/30", Mechanics.class);		
		assertNotNull(updatedMechanics);
	}
	
	@Test
	public void testDeleteMechanics() {
		MechanicsVo mechvo=restTemplate.getForObject(getRootUrl()+"/mechanics/39", MechanicsVo.class);
		//assertEquals(mech.getId(),101);
		restTemplate.delete(getRootUrl()+"/mechanics/39");
		// try {
			MechanicsVo delmech=restTemplate.getForObject(getRootUrl()+"/mechanics/39", MechanicsVo.class);
			System.out.println(mechvo);
			assertNotEquals(mechvo,delmech);
		/* }
		catch(final HttpClientErrorException e){
			assertEquals(e.getStatusCode(),HttpStatus.NOT_FOUND);
		} */
	}
	
	
	
}