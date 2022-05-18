package com.company.GameStore.repositories;

import com.company.GameStore.models.SalesTax;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;

@Repository
public interface SalesTaxRepository extends JpaRepository<SalesTax, BigDecimal> {
    SalesTax findByState(BigDecimal state);

}
