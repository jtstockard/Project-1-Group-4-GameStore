package com.company.GameStore.controller;

import com.company.GameStore.models.Consoles;
import com.company.GameStore.models.Tshirts;
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

import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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
        tshirts.setModel("Gamecube");
        tshirts.setManufacturer("Nintendo");
        tshirts.setMemoryAmount("128gb");
        tshirts.setPrice(new BigDecimal("199.02"));
        tshirts.setProcessor("Intel");
        tshirts.setQuantity(99);

        List<Tshirts> tshirtsList = new ArrayList<>();
        tshirtsList.add(tshirts);
        doReturn(tshirtsList).when(serviceLayer).findAllTshirts();
    }

    @Test
    public void getAllTshirts() {



        List<Tshirts> tshirtsList = new ArrayList<>();
        tshirtsList.add(tshirts);

        String consolesJson = mapper.writeValueAsString(consolesList);

        mockMvc.perform(get("/consoles"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(consolesJson));

    }

    @Test
    public void createTshirt() {
    }

    @Test
    public void getTshirtsByColor() {
    }

    @Test
    public void getTshirtBySize() {
    }

    @Test
    public void updateTshirtsByColor() {
    }

    @Test
    public void updateTshirtsBySize() {
    }

    @Test
    public void deleteTshirtsByColor() {
    }

    @Test
    public void deleteTshirtsBySize() {
    }
}