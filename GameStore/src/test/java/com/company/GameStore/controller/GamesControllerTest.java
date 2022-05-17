package com.company.GameStore.controller;

import com.company.GameStore.models.Consoles;
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

import java.awt.peer.ScrollbarPeer;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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

    private String gamessJson;

    private List<Games> allGames= new ArrayList<>();

    private String allGamesJson;



    private ObjectMapper mapper = new ObjectMapper();

    @Before
    public void setUp() throws Exception {
        Games games = new Games();
        games.setTitle("Grand Theft Auto V");
        games.setEsrbRating("Mature");
        games.setDescription("Enjoy online gameplay with friends and other gamers!");
        games.setPrice(new BigDecimal("29.99"));
        games.setStudio("Rockstar");
        games.setQuantity(99);

        List<Games> gamesList = new ArrayList<>();
        gamesList.add(games);
        doReturn(gamesList).when(serviceLayer).findAllGames();
    }

    @Test
    public void getAllConsoles() throws Exception{
        Games games = new Games();
        games.setTitle("Grand Theft Auto V");
        games.setEsrbRating("Mature");
        games.setDescription("Enjoy online gameplay with friends and other gamers!");
        games.setPrice(new BigDecimal("29.99"));
        games.setStudio("Rockstar");
        games.setQuantity(99);

        List<Games> gamesList = new ArrayList<>();

        String consolesJson = mapper.writeValueAsString(consolesList);

        mockMvc.perform(get("/games"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(consolesJson));

    }



    @Test
    public void getAllGames() {
    }

    @Test
    public void createGame() {
    }

    @Test
    public void getGamesByStudio() {
    }

    @Test
    public void getGamesByRating() {
    }

    @Test
    public void getGamesByTitle() {
    }

    @Test
    public void updateGamesByStudio() {
    }

    @Test
    public void updateGamesByRating() {
    }

    @Test
    public void updateGamesByTitle() {
    }

    @Test
    public void deleteGamesByStudio() {
    }

    @Test
    public void deleteGamesByRating() {
    }

    @Test
    public void deleteGamesByTitle() {
    }
}