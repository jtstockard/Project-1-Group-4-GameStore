package com.company.GameStore.repositories;

import com.company.GameStore.models.Games;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

//@Repository
public interface GamesRepository extends JpaRepository<Games, Integer> {


    List<Games> findByTitle(String title);

    List<Games> findByEsrbRating(String esrbRating);

    List<Games> findByDescription(String description);

    List<Games> findByPrice(BigDecimal price);

    List<Games> findByStudio(String studio);

    List<Games> findByQuantity(int quantity);

}
