package com.company.GameStore.repositories;

import com.company.GameStore.models.Games;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class GamesRepositoryTest {

    @Autowired
    GamesRepository gamesRepository;

    @Before
    public void setUp() throws Exception {
        gamesRepository.deleteAll();
    }

    @Test
    public void addGetDeleteGames() {

        Games games = new Games();
        games.setTitle("Mario");
        games.setEsrbRating("E");
        games.setDescription("Yahoo!");
        games.setPrice(new BigDecimal("59.99"));
        games.setStudio("Nintendo");
        games.setQuantity(999);

        games = gamesRepository.save(games);

        Optional<Games> games1 = gamesRepository.findById(games.getId());

        assertEquals(games1.get(), games);

        gamesRepository.deleteById(games.getId());

        games1 = gamesRepository.findById(games.getId());

        assertFalse(games1.isPresent());
    }

    @Test
    public void updateGames() {
        Games games = new Games();
        games.setTitle("Mario");
        games.setEsrbRating("E");
        games.setDescription("Yahoo!");
        games.setPrice(new BigDecimal("59.99"));
        games.setStudio("Nintendo");
        games.setQuantity(999);

        games = gamesRepository.save(games);

        games.setTitle("God Of War");
        games.setEsrbRating("M");
        games.setDescription("Hades Awaits");
        games.setPrice(new BigDecimal("49.99"));
        games.setStudio("Sony");
        games.setQuantity(123);


        gamesRepository.save(games);

        Optional<Games> games1 = gamesRepository.findById(games.getId());
        assertEquals(games1.get(), games);
    }

    @Test
    public void getAllGames() {

        Games games = new Games();
        games.setTitle("Mario");
        games.setEsrbRating("E");
        games.setDescription("Yahoo!");
        games.setPrice(new BigDecimal("59.99"));
        games.setStudio("Nintendo");
        games.setQuantity(999);

        games = gamesRepository.save(games);

        games = new Games();
        games.setTitle("Cuphead");
        games.setEsrbRating("T");
        games.setDescription("Rubberhose Cartoons that shoot");
        games.setPrice(new BigDecimal("55.00"));
        games.setStudio("MDHR");
        games.setQuantity(101);

        games = gamesRepository.save(games);

        List<Games> gList = gamesRepository.findAll();
        assertEquals(gList.size(), 2);

    }

}