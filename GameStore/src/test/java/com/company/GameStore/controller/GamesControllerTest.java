package com.company.GameStore.controller;

import com.company.GameStore.models.Games;
import com.company.GameStore.service.ServiceLayer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(GamesController.class)

public class GamesControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    ServiceLayer serviceLayer;

    private Games games;

    private String gamesJson;

    private List<Games> allGames= new ArrayList<>();

    private String allGamesJson;


    private ObjectMapper mapper = new ObjectMapper();

    @Before
    public void setUp() throws Exception {
        Games games = new Games();
        games.setTitle("Mario");
        games.setEsrbRating("E");
        games.setDescription("Yahoo!");
        games.setPrice(new BigDecimal("$59.99"));
        games.setStudio("Nintendo");
        games.setQuantity(999);

        Games games1 = new Games();
        games1.setTitle("God Of War");
        games1.setEsrbRating("M");
        games1.setDescription("Hades Awaits");
        games1.setPrice(new BigDecimal("$49.99"));
        games1.setStudio("Sony");
        games1.setQuantity(123);

        Games games2 = new Games();
        games2.setTitle("Cuphead");
        games2.setEsrbRating("T");
        games2.setDescription("Rubberhose Cartoons that shoot");
        games2.setPrice(new BigDecimal("$55.00"));
        games2.setStudio("MDHR");
        games2.setQuantity(101);

        List<Games> gamesList = new ArrayList<>();
        gamesList.add(games);
        gamesList.add(games1);
        gamesList.add(games2);
        String gamesJson = mapper.writeValueAsString(gamesList);
    }

    @Test
    public void getAllGames() throws Exception{

        List<Games> gamesList = new ArrayList<>();
        gamesList.add(games);
        String gamesJson = mapper.writeValueAsString(gamesList);

        mockMvc.perform(get("/games"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(gamesJson));

    }
    @Test
    public void createGame() throws Exception{
        Games games = new Games();
        games.setTitle("Fallout");
        games.setEsrbRating("M");
        games.setDescription("Explore an apocalypse wasteland");
        games.setPrice(new BigDecimal("$99.99"));
        games.setStudio("Bethesda");
        games.setQuantity(420);

        String gamesJson = mapper.writeValueAsString(games);

        mockMvc.perform(put("/games"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(gamesJson));

    }

    @Test
    public void getGameById() throws Exception{

        List<Games> gamesList = new ArrayList<>();
        gamesList.add(games);
        String gamesJson = mapper.writeValueAsString(gamesList);

        mockMvc.perform(get("/games/{2}"))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(gamesJson));

    }

    @Test
    public void updateGame() throws Exception {
        Games games = new Games();
        games.setTitle("Minecraft");
        games.setEsrbRating("E");
        games.setDescription("Build Something");
        games.setPrice(new BigDecimal("$0.99"));
        games.setStudio("Microsoft");
        games.setQuantity(10000);

        List<Games> gamesList = new ArrayList<>();
        gamesList.add(games);
        String gamesJson = mapper.writeValueAsString(gamesList);

        mockMvc.perform(post("/games/{2}"))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(gamesJson));
    }

    @Test
    public void deleteGame() throws Exception {
        mockMvc.perform(delete("/games/{2}"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }
}
