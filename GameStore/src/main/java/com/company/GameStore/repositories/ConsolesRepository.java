package com.company.GameStore.repositories;

import com.company.GameStore.models.Consoles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface ConsolesRepository extends JpaRepository<Consoles, Integer> {


    List<Consoles> findByModel(String model);

    List<Consoles> findByManufacturer(String manufacturer);

    List<Consoles> findByMemoryAmount(String memoryAmount);

    List<Consoles> findByProcessor(String processor);

    List<Consoles> findByPrice(BigDecimal price);

    List<Consoles> findByQuantity(int quantity);


}
