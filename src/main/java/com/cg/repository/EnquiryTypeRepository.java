package com.cg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.model.EnquiryType;

@Repository
public interface EnquiryTypeRepository extends JpaRepository<EnquiryType,Long>{

}
