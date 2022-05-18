package com.company.GameStore.repositories;

import com.company.GameStore.models.ProcessingFees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface ProcessingFeeRepository extends JpaRepository<ProcessingFees, String> {

}
