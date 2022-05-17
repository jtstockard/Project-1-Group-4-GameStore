package com.company.GameStore.controller;

import com.company.GameStore.models.Consoles;
import com.company.GameStore.models.Tshirts;
import com.company.GameStore.service.ServiceLayer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

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

    @Test
    public void getAllTshirts() {
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