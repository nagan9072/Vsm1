package com.cg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.converter.UserConverter;
import com.cg.exception.DuplicateRecordFoundException;
import com.cg.exception.ResourceNotFoundException;
import com.cg.model.User;
import com.cg.repository.UserRepository;
import com.cg.vo.UserVo;

@Service
public class UserService {
	@Autowired
	UserRepository userDao;
	
	@Autowired
	UserConverter userConverter;
	
	/* 
	 * This service method registers a new user
	 * Argument type userVo
	 * Return type String message 
	 */
	public ResponseEntity<String> createUser(UserVo userVo) throws DuplicateRecordFoundException {
		User user = userConverter.voToModel(userVo);
		if(userDao.findByEmail(user.getEmail()).isPresent()) throw new DuplicateRecordFoundException("Enter a valid Email Id");
		if(userDao.findByMobileNumber(user.getMobileNumber()).isPresent()) throw new DuplicateRecordFoundException("Mobile Number already present: Enter a valid Number");
		System.out.println(user.getRole().getRoleId());
		user = userDao.save(user);
		UserVo updatedUserVo = userConverter.modelToVo(user);
		return new ResponseEntity<>("Registered SuccessFully!!! "+updatedUserVo.getFirstName(),  HttpStatus.OK);		
	}

	/* 
	 * This service method retrieves all users
	 * No Arguments
	 * Return type List<UserVo>
	 */
	
	public List<UserVo> getAllUsers(){
		List<User> userList = userDao.findAll();
		return userConverter.modelToVo(userList);
	}
	
	/* 
	 * This service method retrieves all users 
	 * Argument type String username
	 * Return type List<User>
	 */
	
	public List<User> getUserByName(String userName){
		return userDao.findByFirstName(userName);
	}
	

	/* 
	 * This service method retrieves a unique user
	 * Throws ResourceNotFoundException
	 * Argument type long userid
	 * Return type UserVo
	 */
	
	public UserVo getUserById(long userId) throws ResourceNotFoundException {
		User user = userDao.findById(userId).orElseThrow(()-> new ResourceNotFoundException("No User with id "+userId));
		UserVo userVo = userConverter.modelToVo(user);
		return userVo;
	}
	

	/* 
	 * This service method updates user values
	 * Throws ResourceNotFoundException
	 * Argument type long and UserVo
	 * Return type UserVo
	 */
	public UserVo updateUserById(long userId,UserVo userVo) throws ResourceNotFoundException, DuplicateRecordFoundException {
		User newUser = userDao.findById(userId).orElseThrow(()-> new ResourceNotFoundException("No User with id "+userId));
		newUser.setFirstName(userVo.getFirstName());
		newUser.setLastName(userVo.getLastName());
		if(userDao.findByEmail(newUser.getEmail()).isPresent()) throw new DuplicateRecordFoundException("Enter a non-existing email id");
		newUser.setEmail(userVo.getEmail());
		if(userDao.findByMobileNumber(newUser.getMobileNumber()).isPresent()) throw new DuplicateRecordFoundException("Enter a non-exixting mobile number");
		newUser.setMobileNumber(userVo.getMobileNumber());
		userDao.save(newUser);
		UserVo updatedUserVo = userConverter.modelToVo(newUser);
		return updatedUserVo;
	}
	

	/* 
	 * This service method removes a user
	 * Throws ResourceNotFoundException
	 * Argument type long
	 * Return type string
	 */
	
	public String deleteUser(long userId) throws ResourceNotFoundException{
		User user = userDao.findById(userId).orElseThrow(()-> new ResourceNotFoundException("No User with id "+userId));
		userDao.delete(user);
		return "Record Deleted Successfully!!";
	}
	
	/* 
	 * This service method logins a user
	 * Throws ResourceNotFoundException
	 * Argument type String String
	 * Return type Boolean
	 */
	public Boolean userLogin(String userEmail, String userPass) throws ResourceNotFoundException{
		User user =  userDao.findByEmail(userEmail).orElseThrow(()-> new ResourceNotFoundException("No user with emailId "+userEmail));
		boolean flag = user.getPassword().equals(userPass);
		return flag;
	}
	
	/* 
	 * This service method finds a user
	 * Throws ResourceNotFoundException
	 * Argument type String
	 * Return type string
	 */
	public String forgotPassword(String userEmail) throws ResourceNotFoundException {
		@SuppressWarnings("unused")
		User user =  userDao.findByEmail(userEmail).orElseThrow(()-> new ResourceNotFoundException("No user with emailId "+userEmail));
		return "Valid Email";
	}
	
	/* 
	 * This service method updates a user password
	 * Argument type String ,Uservo
	 * Return type UserVo
	 */
	public UserVo updateUserPassword(String userPass,UserVo userVo) {
		User user = userConverter.voToModel(userVo);
		user.setPassword(userPass);
		userDao.save(user);
		return userConverter.modelToVo(user);
	}
}

