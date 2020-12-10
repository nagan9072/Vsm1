package com.cg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import com.cg.model.ServicePrice;


@Repository
public interface ServicePriceRepository extends JpaRepository<ServicePrice, Long> {
   public Optional<ServicePrice> findByServiceAmount(long serviceAmount);
}
