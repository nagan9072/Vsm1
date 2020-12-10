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

import com.cg.service.VehicleTypeService;

import com.cg.validation.ValidCheck;

import com.cg.vo.VehicleTypeVo;

@RestController
public class VehicleTypeController {
	@Autowired
	VehicleTypeService service;
	@Autowired
	private ValidCheck valid;
	/*
	 * This method adds entity in VehicleType table
	 */
	@PostMapping("/vehicletype/newvehicle")
	public ResponseEntity<String> createVehicleType(@RequestBody VehicleTypeVo vo) throws IntrusionException, ValidationException, InvalidInputException, DuplicateRecordFoundException {
		boolean res = valid.vehicletypeCheck(vo);
		ResponseEntity<String> result= null;
		if(res) {
			result = service.createVehicleTypes(vo);
		}
		return result;
	}
	
	/*
	 * This method returns all the entities from VehicleType table
	 */
	@GetMapping("/vehicletype/all")
	public ResponseEntity<List<VehicleTypeVo>> getVehicleTypes(){
		List<VehicleTypeVo> vo=service.getAllVehicleType();
		return ResponseEntity.ok(vo);

	}
	
	/*
	 * This method adds filters and finds using VehicleTypeId in vehicleType table
	 */
	@GetMapping("/vehicletype/{id}")
	public ResponseEntity<VehicleTypeVo> getVehicleTypeById(@PathVariable(value="id") long Id) throws ResourceNotFoundException{
		VehicleTypeVo vo=service.getVehicleTypeById(Id);
		return ResponseEntity.ok().body(vo);
	}
	
	/*
	 * This method delete entity in VehicleType table
	 */
	@DeleteMapping("/vehicletype/{id}")
	public String deleteVehicleType(@PathVariable(value="id") long Id) throws ResourceNotFoundException{
		String result=service.deleteVehicleType(Id);
		return result;
	}
	
	/*
	 * This method update entity in VehicleType table
	 */
	@PutMapping("/vehicletype/{id}")
	public ResponseEntity<VehicleTypeVo> updateRole(@PathVariable(value="id") long Id,@RequestBody VehicleTypeVo v) throws ResourceNotFoundException, IntrusionException, ValidationException, InvalidInputException{
		boolean res = valid.vehicletypeCheck(v);
		VehicleTypeVo result= null;
		if(res) {
			result = service.updateVehicleType(Id,v);
		}
			
		return ResponseEntity.ok().body(result);
	
	}
	

}
