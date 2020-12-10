package com.cg.controller;

import java.util.List;

import org.owasp.esapi.errors.IntrusionException;
import org.owasp.esapi.errors.ValidationException;
//import org.owasp.esapi.errors.IntrusionException;
//import org.owasp.esapi.errors.ValidationException;
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
import com.cg.exception.InvalidInputException;
import com.cg.exception.ResourceNotFoundException;
import com.cg.model.User;
import com.cg.service.UserService;
import com.cg.validation.ValidCheck;
import com.cg.vo.UserVo;
import com.cg.vo.VehicleTypeVo;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	ValidCheck valid;
	
	/* 
	 * This method adds entity to the user Table 
	 */
	@PostMapping("/users/newuser")
	public ResponseEntity<String> createUser(@RequestBody UserVo vo) throws DuplicateRecordFoundException, IntrusionException, ValidationException, InvalidInputException{
		System.out.println(vo.getRoleVo().getRoleId());
		boolean res = valid.userCheck(vo);
		ResponseEntity<String> result= null;
		if(res) {
			result = userService.createUser(vo);
		}
		return result;
	}
	
	/* 
	 * This method gets all user objects from the user Table 
	 */
	
	@GetMapping("/users/all")
	public ResponseEntity<List<UserVo>> getAllUsers(){
		List<UserVo> userVoList = userService.getAllUsers();
		return ResponseEntity.ok(userVoList);
	}
  	/* 
	 * This method retrieve user object by providing user Id
	 */
	@GetMapping("/users/id/{id}")
	public ResponseEntity<UserVo> getUserById(@PathVariable(value = "id") long userId) throws ResourceNotFoundException{
		UserVo userVo = userService.getUserById(userId);
		return ResponseEntity.ok().body(userVo);
	}
	
	/* 
	 * This method retrieve user object by providing user Name
	 */
	@GetMapping("/users/name/{name}")
	public List<User> getUserByUserName(@PathVariable(value = "name") String userName) throws ResourceNotFoundException{
		List<User> userList = userService.getUserByName(userName);
		if(userList.size()==0) throw new ResourceNotFoundException("No Users with the name: "+userName);
		return userList;
	}
	 
	/* 
	 * This method updates user object by providing user Id
	 */
	@PutMapping("/users/update/{id}")
	public ResponseEntity<UserVo> updateUserById(@PathVariable(value = "id") long Id,@RequestBody UserVo userVo) throws ResourceNotFoundException, DuplicateRecordFoundException, IntrusionException, ValidationException, InvalidInputException{
		boolean res = valid.userCheck(userVo);
		UserVo result= null;
		if(res) {
			result = userService.updateUserById(Id,userVo);
		}
			
		return ResponseEntity.ok().body(result);
	}
	
	/* 
	 * This method deletes user object by providing user Id
	 */
	@DeleteMapping("/users/delete/{id}")
	public String deleteUserById(@PathVariable(value="id") long userId) throws ResourceNotFoundException{
		return userService.deleteUser(userId);	}
	
	/* 
	 * This method performs login operation
	 */
	@GetMapping("/users/login/{email}/{pass}")
	public String loginByUserEmail(@PathVariable(value="email") String userEmail, @PathVariable(value="pass") String userPass) throws ResourceNotFoundException{
		boolean flag  = userService.userLogin(userEmail, userPass);
		if(flag==true) return "Login Successful";
		return "Invalid email or Password";
	}
	
	/* 
	 * This method checks presence of valid email 
	 */
	@GetMapping("/users/forgotpassword/{email}")
	public String forgotPassword(@PathVariable(value = "email") String userEmail) throws ResourceNotFoundException{
		String result	= userService.forgotPassword(userEmail);
		return result;
	}
	
	/* 
	 * This method resets the user password
	 */
	@SuppressWarnings("unused")
	@PutMapping("/users/changepassword/{pass}")
	public String changeUserPassword(@PathVariable(value="pass") String userPass,@RequestBody UserVo userVo) throws ResourceNotFoundException{
		UserVo updatedUserVo = userService.updateUserPassword(userPass,userVo);
		return "Password Changed";
	}
}

