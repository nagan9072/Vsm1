package com.cg.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	/* 
	 * This method retrieves user by name
	 * Argument type string
	 * Return type list 
	 */
	public List<User> findByFirstName(String userName);
	/* 
	 * This method retrieves user by email
	 * Argument type string
	 * Return type optional 
	 */
	public Optional<User> findByEmail(String email);
	/* 
	 * This method retrieves user by number
	 * Argument type string
	 * Return type optional 
	 */
	public Optional<User> findByMobileNumber(String number);

}