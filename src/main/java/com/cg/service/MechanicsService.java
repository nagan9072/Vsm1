package com.cg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import com.cg.exception.DuplicateRecordFoundException;
import com.cg.exception.ResourceNotFoundException;
import com.cg.converter.MechanicsConverter;
import com.cg.model.Mechanics;
import com.cg.repository.MechanicsRepository;
import com.cg.vo.MechanicsVo;

@Service
public class MechanicsService {
	@Autowired
	private MechanicsRepository mechRepo;
	@Autowired
	private MechanicsConverter converter;
	/*
	 * This method adds entity to Mechanics table
	 */
	
	  public ResponseEntity<String> createMechanics(MechanicsVo vo)throws DuplicateRecordFoundException { 
	Mechanics mechanic=converter.voToModel(vo); 
	if(mechRepo.findByEmail(mechanic.getEmail()).isPresent()) throw new DuplicateRecordFoundException("Enter a valid Email Id");
	

	mechanic=mechRepo.save(mechanic);
	  MechanicsVo mvo=converter.modelToVo(mechanic); 
	  return new ResponseEntity<>("Registered SuccessFully!!! "+mvo.getFirstName(), HttpStatus.OK); 
	  }
	 
	
	/*
	 * This method shows all the mechanics the Mechanics table
	 */
	public List<MechanicsVo> getAllMechanics(){
		List<Mechanics> st=mechRepo.findAll();
		return converter.modelToVo(st);
	}
	
	/*
	 * This method adds filters and finds using mechanicId in mechanics table
	 */
	public MechanicsVo getMechanicById(long id) throws ResourceNotFoundException{
		Mechanics mechanic=mechRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("no student found with this id "+id ));
		MechanicsVo vo=converter.modelToVo(mechanic);
		return vo;
	}
	/*
	 * This method adds filters and finds using mechanicName in mechanics table
	 */
	public MechanicsVo getMechanicByNumber(String number)throws ResourceNotFoundException{
		Mechanics mechanic=mechRepo.findBymobileNumber(number);
		MechanicsVo vo=converter.modelToVo(mechanic);
		return vo;
		//return mechRepo.findByfirstName(name);
	}
	/*
	 * This method updates the Mechanics table
	 */
	public MechanicsVo updateMechanic(long id, MechanicsVo v) throws ResourceNotFoundException {
		Mechanics mechanic=mechRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("no student found with this id "+id ));
		mechanic.setFirstName(v.getFirstName());
		mechanic.setAddress(v.getAddress());
		mechRepo.save(mechanic);
		MechanicsVo vo=converter.modelToVo(mechanic);
		return vo;
		//return mechRepo.save(mechanic);
	}
	/*
	 * This method delete a mechanic the Mechanics table
	 */
	public String deleteMechanics(long id) throws ResourceNotFoundException {
		Mechanics mechanic=mechRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("no student found with this id "+id ));
		mechRepo.delete(mechanic);
		return "Record Deleted Successfully!!";
		//mechRepo.delete(mechanic);
	}

}
