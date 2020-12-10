package com.cg.controller;

import java.util.List;

import org.owasp.esapi.errors.IntrusionException;
import org.owasp.esapi.errors.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.converter.EnquiryTypeConverter;
import com.cg.exception.DuplicateRecordFoundException;
import com.cg.exception.InvalidInputException;
import com.cg.exception.ResourceNotFoundException;
import com.cg.model.EnquiryType;
import com.cg.service.EnquiryTypeService;
import com.cg.validation.ValidCheck;
import com.cg.vo.EnquiryTypeVo;

@RestController
public class EnquiryTypeController {
	
	@Autowired
	private EnquiryTypeService services;
	
	@Autowired
	private ValidCheck valid;
	
	
	/*
	 * Adding new EnquiryType 
	 */
	@PostMapping("/enquirytype/new")
	public ResponseEntity<String> addEnquiryType(@RequestBody EnquiryTypeVo vo) throws DuplicateRecordFoundException,IntrusionException, ValidationException, InvalidInputException {
		boolean value = valid.enquiryTypeCheck(vo);
		ResponseEntity<String> result=null;
		if(value) {
			result = services.addEnquiryType(vo);
		}
		return result;
	}
	
	/*
	 * Viewing EnquiryType 
	 */
	@GetMapping("/enquirytype/all")
	public ResponseEntity<List<EnquiryTypeVo>> getAllEnquiryTypes() {
		List<EnquiryTypeVo> vo=services.getAllEnquiryTypes();
		return ResponseEntity.ok(vo);
	}
	
	/*
	 * Finding EnquiryType by Id 
	 */
	@GetMapping("/enquirytype/{id}")
	public ResponseEntity<EnquiryTypeVo> getEnquiryTypeById(@PathVariable(value="id") long id) throws ResourceNotFoundException {
		EnquiryTypeVo vo=services.getEnquTypeById(id);
		return ResponseEntity.ok().body(vo);
	}
	
	/*
	 * Updating EnquiryType by Id 
	 */
	@PutMapping("/enquirytype/{id}")
	public ResponseEntity<EnquiryTypeVo> updateEnquiryType(@PathVariable(value="id") long id,@RequestBody EnquiryTypeVo v) throws ResourceNotFoundException, IntrusionException, ValidationException, InvalidInputException, DuplicateRecordFoundException {
		boolean value = valid.enquiryTypeCheck(v);
		EnquiryTypeVo result = null;
		if(value)
		{
			result = services.updateEnquiryType(id, v);
		}
		return ResponseEntity.ok().body(result);
	}
	
	/*
	 * Deleting EnquiryType by Id 
	 */
	@DeleteMapping("/enquirytype/{id}")
	public String deleteEnquiryType(@PathVariable(value="id") long id) throws ResourceNotFoundException{
		String result=services.deleteEnquiryType(id);
		return result;
	}
	
}
