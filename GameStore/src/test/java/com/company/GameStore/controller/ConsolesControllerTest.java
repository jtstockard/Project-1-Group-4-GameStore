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
@WebMvcTest(ConsolesController.class)

public class ConsolesControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    ServiceLayer serviceLayer;

    private Consoles consoles;

    private String consolesJson;

    private List<Consoles> allConsoles = new ArrayList<>();

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

        Consoles consoles1 = new Consoles();
        consoles1.setModel("PlayStation 3");
        consoles1.setManufacturer("Sony");
        consoles1.setMemoryAmount("256gb");
        consoles1.setPrice(new BigDecimal("599.99"));
        consoles1.setProcessor("Intel");
        consoles1.setQuantity(75);

        Consoles consoles2 = new Consoles();
        consoles2.setModel("Xbox");
        consoles2.setManufacturer("Microsoft");
        consoles2.setMemoryAmount("512gb");
        consoles2.setPrice(new BigDecimal("725.01"));
        consoles2.setProcessor("AMD");
        consoles2.setQuantity(10);

        List<Consoles> consolesList = new ArrayList<>();
        consolesList.add(consoles);
        consolesList.add(consoles1);
        consolesList.add(consoles2);
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

        Consoles consoles1 = new Consoles();
        consoles1.setModel("PlayStation 3");
        consoles1.setManufacturer("Sony");
        consoles1.setMemoryAmount("256gb");
        consoles1.setPrice(new BigDecimal("599.99"));
        consoles1.setProcessor("Intel");
        consoles1.setQuantity(75);

        Consoles consoles2 = new Consoles();
        consoles2.setModel("Xbox");
        consoles2.setManufacturer("Microsoft");
        consoles2.setMemoryAmount("512gb");
        consoles2.setPrice(new BigDecimal("725.01"));
        consoles2.setProcessor("AMD");
        consoles2.setQuantity(10);

        List<Consoles> consolesList = new ArrayList<>();
        consolesList.add(consoles);
        consolesList.add(consoles1);
        consolesList.add(consoles2);
        doReturn(consolesList).when(serviceLayer).findAllConsoles();

        String consolesJson = mapper.writeValueAsString(consolesList);

        mockMvc.perform(get("/console"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(consolesJson));

    }

      @Test
        public void createConsole() throws Exception{
        Consoles consoles = new Consoles();
        consoles.setModel("Gamecube");
        consoles.setManufacturer("Nintendo");
        consoles.setMemoryAmount("128gb");
        consoles.setPrice(new BigDecimal("199.02"));
        consoles.setProcessor("Intel");
        consoles.setQuantity(99);


        String consolesJson = mapper.writeValueAsString(consoles);

            mockMvc.perform(get("/console"))
               .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(consolesJson));

    }

   @Test
   public void getConsoleById() throws Exception{
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

       mockMvc.perform(get("/console"))
               .andDo(print())
               .andExpect(status().isCreated())
               .andExpect(content().json(consolesJson));

   }

   @Test
    public void updateConsole() throws Exception {
       Consoles consoles = new Consoles();
       consoles.setModel("Nvidia");
       consoles.setManufacturer("Google");
       consoles.setMemoryAmount("1tb");
       consoles.setPrice(new BigDecimal("399.99"));
       consoles.setProcessor("Intel");
       consoles.setQuantity(2);

       List<Consoles> consolesList = new ArrayList<>();
       consolesList.add(consoles);
       String consolesJson = mapper.writeValueAsString(consolesList);

       mockMvc.perform(post("/console/{2}"))
               .andDo(print())
               .andExpect(status().isCreated())
               .andExpect(content().json(consolesJson));
    }

  @Test
   public void deleteConsole() throws Exception {
      mockMvc.perform(delete("/console/2"))
              .andDo(print())
              .andExpect(status().isNoContent());
 }
}
