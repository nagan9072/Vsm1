package com.cg.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.cg.model.User;
import com.cg.vo.UserVo;

@Component
public class UserConverter{
	
	/* 
	 * This method converts model object to value object 
	 * Returns userVo object
	 * Argument type user
	 */
	public UserVo modelToVo(User user) {
		UserVo userVo = new UserVo();
		userVo.setUserId(user.getUserId());
		userVo.setFirstName(user.getFirstName());
		userVo.setLastName(user.getLastName());
		userVo.setMobileNumber(user.getMobileNumber());
		userVo.setEmail(user.getEmail());
		userVo.setPassword(user.getPassword());
		return userVo;
	}
	
	/* 
	 * This method converts model object to value object 
	 * Returns userVo object list
	 * Argument type List<user>
	 */
	public List<UserVo> modelToVo(List<User> userList){
		
		return userList.stream().map(x -> modelToVo(x)).collect(Collectors.toList());
	}
	
	/* 
	 * This method converts value object to model object 
	 * Returns user object
	 * Argument type userVo
	 */
	public User voToModel(UserVo userVo) {
		User user = new User();
		user.setUserId(userVo.getUserId());
		user.setFirstName(userVo.getFirstName());
		user.setLastName(userVo.getLastName());
		user.setMobileNumber(userVo.getMobileNumber());
		user.setEmail(userVo.getEmail());
		user.setPassword(userVo.getPassword());
		return user;
	}
	
	/* 
	 * This method converts value object to model object 
	 * Returns user object list
	 * Argument type List<userVo>
	 */
	public List<User> voToModel(List<UserVo> userVoList){
		
		return userVoList.stream().map(x -> voToModel(x)).collect(Collectors.toList());
	}
}

