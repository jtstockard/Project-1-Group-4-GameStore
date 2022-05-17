package com.company.GameStore.controller;

import com.company.GameStore.models.Consoles;
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
import java.util.Optional;

import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ConsolesController.class)

public class ConsolesControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    ServiceLayer serviceLayer;

    private Consoles consoles;

    private String consolesJson;

    private List<Consoles> allConsoles= new ArrayList<>();

    private String allConsolesJson;


    private ObjectMapper mapper = new ObjectMapper();

    @Before
    public void setUp() throws Exception {
        Consoles consoles = new Consoles();
        consoles.setModel("Gamecube");
        consoles.setManufacturer("Nintendo");
        consoles.setMemoryAmount("128gb");
        consoles.setPrice(new BigDecimal("199.02"));
        consoles.setProcessor("Intel");
        consoles.setQuantity(99);

        List<Consoles> consolesList = new ArrayList<>();
        consolesList.add(consoles);
        doReturn(consolesList).when(serviceLayer).findAllConsoles();
    }

    @Test
    public void getAllConsoles() throws Exception{
        Consoles consoles = new Consoles();
        consoles.setModel("Gamecube");
        consoles.setManufacturer("Nintendo");
        consoles.setMemoryAmount("128gb");
        consoles.setPrice(new BigDecimal("199.02"));
        consoles.setProcessor("Intel");
        consoles.setQuantity(99);

        List<Consoles> consolesList = new ArrayList<>();
        consolesList.add(consoles);

        String consolesJson = mapper.writeValueAsString(consolesList);

        mockMvc.perform(get("/consoles"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(consolesJson));

    }

    @Test
    public void shouldCreateConsole() throws Exception {


//        mockMvc.perform(post("/consoles")
//                        .content(inputConsoleString)
//                        .contentType(MediaType.APPLICATION_JSON)
//                ).andDo(print())
//                .andExpect(status().isCreated())
//                .andExpect(content().json(outputConsoleString));
    }


    @Test
    public void shouldReturnByManufacturer() throws Exception {

    }

    @Test
    public void shouldDeleteConsole() throws Exception {

    }

//
//    @Test
//    public void getAllTshirts() throws Exception{
//        Tshirts tshirts = new Tshirts();
//        tshirts.setSize("");
//        consoles.setManufacturer("Nintendo");
//        consoles.getMemoryAmount("128gb");
//        consoles.getPrice(199.02);
//        consoles.getProcessor("Intel");
//        consoles.getQuantity(99);
//
//        List<Consoles> consolesList = new ArrayList<>();
//        consolesList.add(consoles);
//
//        String consolesJson = mapper.writeValueAsString(consolesList);
//
//        mockMvc.perform(get("/consoles"))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(content().json(consolesJson));
//
//    }

//    @Test
//    public void createConsole() throws Exception{
//        Consoles consoles = new Consoles();
//        consoles.setModel("Gamecube");
//        consoles.setManufacturer("Nintendo");
//        consoles.getMemoryAmount("128gb");
//        consoles.getPrice(199.02);
//        consoles.getProcessor("Intel");
//        consoles.getQuantity(99);
//
//        String inputJson = mapper.writeValueAsString(consoles);
//
//        doReturn(consoles).when(repo).save(input);
//
//        mockMvc.perform(put("/consoles"))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(content().json(outputJson));
//
//    }
//
//    @Test
//    public void getConsoleById() {
//    }
//
//    @Test
//    public void updateConsole() {
//    }
//
//    @Test
//    public void deleteConsole() {
//    }
}
