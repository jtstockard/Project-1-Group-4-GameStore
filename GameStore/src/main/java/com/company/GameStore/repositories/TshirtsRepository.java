package com.company.GameStore.repositories;

import com.company.GameStore.models.Tshirts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface TshirtsRepository extends JpaRepository<Tshirts, Integer> {

    List<Tshirts> findById(int id);

    List<Tshirts> findBySize(String size);

    List<Tshirts> findByColor(String color);

    List<Tshirts> findByDescription(String description);

    List<Tshirts> findByPrice(BigDecimal price);

    List<Tshirts> findByQuantity(int quantity);
}
