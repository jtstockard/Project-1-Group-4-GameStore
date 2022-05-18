package com.company.GameStore.controller;

import com.company.GameStore.models.Tshirts;
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
import java.util.List;

import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(TshirtsController.class)

public class TshirtsControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    ServiceLayer serviceLayer;

    private Tshirts tshirts;

    private String tshirtsJson;

    private List<Tshirts> allTshirts= new ArrayList<>();

    private String allTshirtssJson;



    private ObjectMapper mapper = new ObjectMapper();

    @Before
    public void setUp() throws Exception {
        Tshirts tshirts = new Tshirts();

        tshirts.setSize("L");
        tshirts.setColor("Yellow");
        tshirts.setDescription("Ironic tshirt");
        tshirts.setPrice(new BigDecimal("9.99"));
        tshirts.setQuantity(999);

        Tshirts tshirts1 = new Tshirts();
        tshirts1.setSize("XL");
        tshirts1.setColor("Black");
        tshirts1.setDescription("Anime shirt");
        tshirts1.setPrice(new BigDecimal("34.99"));
        tshirts1.setQuantity(23);

        Tshirts tshirts2 = new Tshirts();
        tshirts2.setSize("XXL");
        tshirts2.setColor("Orange");
        tshirts2.setDescription("Killer robot tshirt");
        tshirts2.setPrice(new BigDecimal("25.00"));
        tshirts2.setQuantity(102);

        List<Tshirts> tshirtsList = new ArrayList<>();
        tshirtsList.add(tshirts);
        tshirtsList.add(tshirts1);
        tshirtsList.add(tshirts2);
        doReturn(tshirtsList).when(serviceLayer).getAllTshirts();
        String tshirtsJson = mapper.writeValueAsString(tshirtsList);
    }

    @Test
    public void getAllTshirts() throws Exception{

        List<Tshirts> tshirtsList = new ArrayList<>();
        tshirtsList.add(tshirts);
        String tshirtsJson = mapper.writeValueAsString(tshirtsList);

        mockMvc.perform(get("/tshirts"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(tshirtsJson));

    }
    @Test
    public void createTshirt() throws Exception{
        Tshirts inputTshirts = new Tshirts();
        inputTshirts.setSize("L");
        inputTshirts.setColor("Blue");
        inputTshirts.setDescription("Pokemon shirt");
        inputTshirts.setPrice(new BigDecimal("19.99"));
        inputTshirts.setQuantity(420);

        String inputJson = mapper.writeValueAsString(inputTshirts);

        Tshirts outputTshirts = new Tshirts();
        outputTshirts.setSize("L");
        outputTshirts.setColor("Blue");
        outputTshirts.setDescription("Pokemon shirt");
        outputTshirts.setPrice(new BigDecimal("19.99"));
        outputTshirts.setQuantity(420);
        outputTshirts.setId(2);

        String outputJson = mapper.writeValueAsString(outputTshirts);

        mockMvc.perform(put("/tshirts")
                .content(inputJson)                           // Set the request body.
                .contentType(MediaType.APPLICATION_JSON)      // Tell the server it's in JSON format.
        )
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(outputJson));

    }

    @Test
    public void getTshirtById() throws Exception{
        List<Tshirts> tshirtsList = new ArrayList<>();
        tshirtsList.add(tshirts);
        String tshirtsJson = mapper.writeValueAsString(tshirtsList);

        mockMvc.perform(get("/tshirts/{2}"))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(tshirtsJson));

    }

    @Test
    public void updateTshirt() throws Exception {
        Tshirts tshirts = new Tshirts();
        tshirts.setSize("S");
        tshirts.setColor("Pink");
        tshirts.setDescription("Hello Kitty");
        tshirts.setPrice(new BigDecimal("$15.00"));
        tshirts.setQuantity(100);

        List<Tshirts> tshirtsList = new ArrayList<>();
        tshirtsList.add(tshirts);
        String tshirtsJson = mapper.writeValueAsString(tshirtsList);

        mockMvc.perform(post("/tshirts/{2}"))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(tshirtsJson));
    }

    @Test
    public void deleteTshirt() throws Exception {
        mockMvc.perform(delete("/tshirts/{2}"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }
//     @Test
//       public void getTshirtsByColor() {
//       }

//       @Test
//       public void getTshirtBySize() {
//       }

//       @Test
//       public void updateTshirtsByColor() {
//       }

//       @Test
//       public void updateTshirtsBySize() {
//       }

//       @Test
//       public void deleteTshirtsByColor() {
//       }

//       @Test
//       public void deleteTshirtsBySize() {
 }
