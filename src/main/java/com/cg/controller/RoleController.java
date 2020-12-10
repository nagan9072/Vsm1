package com.cg.controller;

import java.util.List;

import org.owasp.esapi.errors.IntrusionException;
import org.owasp.esapi.errors.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cg.exception.DuplicateRecordFoundException;
import com.cg.exception.InvalidInputException;
import com.cg.exception.ResourceNotFoundException;
import com.cg.model.Role;
import com.cg.service.RoleService;
import com.cg.validation.ValidCheck;
import com.cg.vo.RoleVo;

@RestController
public class RoleController {
	@Autowired
	private RoleService service;
	@Autowired
	private ValidCheck valid;
	/*
	 * This method adds entity to Role table
	 */
	@PostMapping("/role/newrole")
	public ResponseEntity<String> createRole(@RequestBody RoleVo vo) throws IntrusionException, ValidationException, InvalidInputException, DuplicateRecordFoundException {
		boolean res = valid.roleCheck(vo);
		ResponseEntity<String> result= null;
		if(res) {
			result = service.createRoles(vo);
		}
			
		return result;
	}
	
	/*
	 * This method returns all the entities from Role table
	 */
	@GetMapping("/role/all")
	public ResponseEntity<List<RoleVo>> getRoles(){
		List<RoleVo> vo=service.getAllRole();
		return ResponseEntity.ok(vo);
	}
	
	/*
	 * This method adds filters and finds using RoleId in Role table
	 */
	@GetMapping("/role/{id}")
	public ResponseEntity<RoleVo> getRoleById(@PathVariable(value="id") long Id) throws ResourceNotFoundException{
		RoleVo vo=service.getRoleById(Id);
		return ResponseEntity.ok().body(vo);
	}
	/*
	 * This method delete the Role table
	 */
	@DeleteMapping("/role/{id}")
	public String deleteRole(@PathVariable(value="id") long Id) throws ResourceNotFoundException{
		String result=service.deleteRole(Id);
		return result;
	}
	/*
	 * This method update the Role table
	 */
	@PutMapping("/role/{id}")
	public ResponseEntity<RoleVo> updateRole(@PathVariable(value="id") long Id,@RequestBody RoleVo v) throws ResourceNotFoundException, IntrusionException, ValidationException, InvalidInputException{
		boolean res = valid.roleCheck(v);
		RoleVo result= null;
		if(res) {
			result = service.updateRole(Id,v);
		}
			
		return ResponseEntity.ok().body(result);
	
	}

}
