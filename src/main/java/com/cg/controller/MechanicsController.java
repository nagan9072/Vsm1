package com.cg.controller;

import java.util.List;

import org.eclipse.jdt.core.compiler.InvalidInputException;
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

import com.cg.exception.DuplicateRecordFoundException;
import com.cg.exception.ResourceNotFoundException;
import com.cg.model.Mechanics;
import com.cg.repository.MechanicsRepository;
import com.cg.service.MechanicsService;
import com.cg.validation.ValidCheck;
import com.cg.vo.MechanicsVo;
import com.cg.vo.ServiceVo;

@RestController
public class MechanicsController {
	@Autowired
	private MechanicsService mechService;
	@Autowired
	private ValidCheck mc;
	/*
	 * This method adds entity to Mechanics table
	 */
	@PostMapping("/mechanics/newmech")
	public ResponseEntity<String> createMechanic(@RequestBody MechanicsVo vo) throws DuplicateRecordFoundException,InvalidInputException,IntrusionException,ValidationException, com.cg.exception.InvalidInputException {
		
		
		ResponseEntity<String> result=null;
		if(mc.mechanicCheck(vo)) {
			 result=mechService.createMechanics(vo);
			
		}
		return result;
	
		//return mechService.createMechanics(mechanic);
	}
	/*
	 * This method shows all the mechanics the Mechanics table
	 */
	@GetMapping("/mechanics/all")
	public ResponseEntity<List<MechanicsVo>> getMechanic() {
		List<MechanicsVo> vo=mechService.getAllMechanics();
		return ResponseEntity.ok(vo);
		//return mechService.getAllMechanics();
	}
	/*
	 * This method adds filters and finds using mechanicId in mechanics table
	 */
	
	@GetMapping("/mechanics/{id}")
	public ResponseEntity<MechanicsVo> getMechanicId(@PathVariable(value="id") Integer mechId) throws ResourceNotFoundException{
		MechanicsVo vo=mechService.getMechanicById(mechId);
		return ResponseEntity.ok().body(vo);
		
		
		//Mechanics Mechanic=mechService.getMechanicById(mechId).orElseThrow(()->new ResourceNotFoundException("no mechanic found with this id "+mechId ));
		//return ResponseEntity.ok().body(Mechanic);
	}
	/*
	 * This method adds filters and finds using mechanicName in mechanics table
	 */
	@GetMapping("/mechanics/number/{num}")
	public ResponseEntity<MechanicsVo> getMechanicNumber(@PathVariable(value="num") String mechNum)throws ResourceNotFoundException {
		MechanicsVo vo=mechService.getMechanicByNumber(mechNum);
		return ResponseEntity.ok().body(vo);
		//return mechService.getMechanicByName(mechName);
	}
	
	@PutMapping("/mechanics/{id}")
	public ResponseEntity<MechanicsVo> updateMechanic(@PathVariable(value="id") Integer id,@RequestBody MechanicsVo v) throws ResourceNotFoundException, IntrusionException, ValidationException, com.cg.exception.InvalidInputException {
		boolean value=mc.mechanicCheck(v);
		MechanicsVo result=null;
		if(value) {
			 result=mechService.updateMechanic(id, v);
		}
		return ResponseEntity.ok().body(result);	
	}
	
	/*
	 * This method delete a mechanic the Mechanics table
	 */
	@DeleteMapping("/mechanics/{id}")
	public String deleteMechanic(@PathVariable(value="id") Integer mechId) throws ResourceNotFoundException {
		String result=mechService.deleteMechanics(mechId);
		return result;
	}
}
