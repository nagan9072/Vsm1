package com.cg.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long>{
	public Optional<Role> findByRoleName(String RoleName);
}
