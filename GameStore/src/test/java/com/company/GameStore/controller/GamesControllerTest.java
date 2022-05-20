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
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
//tells the class that it's a test file
@WebMvcTest(GamesController.class)

public class GamesControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    ServiceLayer serviceLayer;

    private Games inputGames;
    private Games outputGames;
    private String inputGamesString;
    private String outputGamesString;

    private List<Games> allGames;
    private String allGamesString;
    private int gamesId = 1;

    private int nonExistentGamesId = 999;
    private ObjectMapper mapper = new ObjectMapper();

    @Before
    public void setUp() throws Exception {
        Games games = new Games();
        games.setTitle("Mario");
        games.setEsrbRating("E");
        games.setDescription("Yahoo!");
        games.setPrice(new BigDecimal("59.99"));
        games.setStudio("Nintendo");
        games.setQuantity(999);

        Games games1 = new Games();
        games1.setTitle("God Of War");
        games1.setEsrbRating("M");
        games1.setDescription("Hades Awaits");
        games1.setPrice(new BigDecimal("49.99"));
        games1.setStudio("Sony");
        games1.setQuantity(123);

        Games games2 = new Games();
        games2.setTitle("Cuphead");
        games2.setEsrbRating("T");
        games2.setDescription("Rubberhose Cartoons that shoot");
        games2.setPrice(new BigDecimal("55.00"));
        games2.setStudio("MDHR");
        games2.setQuantity(101);

        List<Games> gamesList = new ArrayList<>();
        gamesList.add(games);
        gamesList.add(games1);
        gamesList.add(games2);
        String gamesJson = mapper.writeValueAsString(gamesList);


        inputGames = new Games(1,"Mario", "E", "Yahoo!",new BigDecimal("59.99"), "Nintendo" ,999);
        outputGames = new Games( 1,"Mario", "E", "Yahoo!",new BigDecimal("59.99"), "Nintendo" ,999);
        inputGamesString = mapper.writeValueAsString(inputGames);
        outputGamesString = mapper.writeValueAsString(outputGames);
        allGames = Arrays.asList(outputGames);
        allGamesString = mapper.writeValueAsString(allGames);

        when(serviceLayer.addGames(inputGames)).thenReturn(outputGames);
        when(serviceLayer.getAllGames()).thenReturn(allGames);
        when(serviceLayer.getGamesById(gamesId)).thenReturn(outputGames);


    }

    @Test
    public void shouldGetAllGames() throws Exception{
        Games games = new Games();
        games.setTitle("Mario");
        games.setEsrbRating("E");
        games.setDescription("Yahoo!");
        games.setPrice(new BigDecimal("59.99"));
        games.setStudio("Nintendo");
        games.setQuantity(999);

        Games games1 = new Games();
        games1.setTitle("God Of War");
        games1.setEsrbRating("M");
        games1.setDescription("Hades Awaits");
        games1.setPrice(new BigDecimal("49.99"));
        games1.setStudio("Sony");
        games1.setQuantity(123);

        Games games2 = new Games();
        games2.setTitle("Cuphead");
        games2.setEsrbRating("T");
        games2.setDescription("Rubberhose Cartoons that shoot");
        games2.setPrice(new BigDecimal("55.00"));
        games2.setStudio("MDHR");
        games2.setQuantity(101);

        List<Games> gamesList = new ArrayList<>();
        gamesList.add(games);
        gamesList.add(games1);
        gamesList.add(games2);
        doReturn(gamesList).when(serviceLayer).getAllGames();
        String gamesJson = mapper.writeValueAsString(gamesList);


        mockMvc.perform(get("/games"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(gamesJson));

    }

    @Test
    public void shouldCreateGames() throws Exception{
        mockMvc.perform(post("/games")
                .content(inputGamesString)                           // Set the request body.
                .contentType(MediaType.APPLICATION_JSON)      // Tell the server it's in JSON format.
        )
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(outputGamesString));

    }

    @Test
    public void shouldGetGamesById() throws Exception{
        Games games = new Games();
        games.setId(1);
        games.setTitle("Mario");
        games.setEsrbRating("E");
        games.setDescription("Yahoo!");
        games.setPrice(new BigDecimal("59.99"));
        games.setStudio("Nintendo");
        games.setQuantity(999);

        String gamesJson = mapper.writeValueAsString(games);

        mockMvc.perform(get("/games/" + gamesId))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(gamesJson));

    }

    @Test
    public void shouldUpdateGames() throws Exception {
        Games outputGames = new Games();
        outputGames.setTitle("Minecraft");
        outputGames.setEsrbRating("E");
        outputGames.setDescription("Build Something");
        outputGames.setPrice(new BigDecimal("0.99"));
        outputGames.setStudio("Microsoft");
        outputGames.setQuantity(10000);

        mockMvc.perform(put("/games/" + gamesId)
                        .content(outputGamesString)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    public void shouldDeleteGames() throws Exception {
        mockMvc.perform(delete("/games/" + gamesId))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

//     @Test
//     public void getGamesByStudio() {
//     }

//     @Test
//     public void getGamesByRating() {
//     }

//     @Test
//     public void getGamesByTitle() {
//     }

//     @Test
//     public void updateGamesByStudio() {
//     }

//     @Test
//     public void updateGamesByRating() {
//     }

//     @Test
//     public void updateGamesByTitle() {
//     }

//     @Test
//     public void deleteGamesByStudio() {
//     }

//     @Test
//     public void deleteGamesByRating() {
//     }

//     @Test
//     public void deleteGamesByTitle() {
//     }
}
