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
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;
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

    private Consoles inputConsoles;
    private Consoles outputConsoles;
    private String inputConsolesString;
    private String outputConsolesString;

    private List<Consoles> allConsoles;
    private String allConsolesString;
    private int consolesId = 1;

    private int nonExistentConsolesId = 999;

    private ObjectMapper mapper = new ObjectMapper();

    @Before
   public void setUp() throws Exception {
        Consoles consoles = new Consoles(0,"Gamecube", "Nintendo", "128gb", "Intel", new BigDecimal("199.02"), 99);

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

        inputConsoles = new Consoles(1,"Gamecube", "Nintendo", "128gb", "Intel", new BigDecimal("199.02"), 99);
        outputConsoles = new Consoles( 1,"Gamecube", "Nintendo", "128gb", "Intel", new BigDecimal("199.02"), 99);
        inputConsolesString = mapper.writeValueAsString(inputConsoles);
        outputConsolesString = mapper.writeValueAsString(outputConsoles);
        allConsoles = Arrays.asList(outputConsoles);
        allConsolesString = mapper.writeValueAsString(allConsoles);

        when(serviceLayer.addConsoles(inputConsoles)).thenReturn(outputConsoles);
        when(serviceLayer.findAllConsoles()).thenReturn(allConsoles);
        when(serviceLayer.getAConsoles(consolesId)).thenReturn(outputConsoles);

}

    @Test
    public void shouldGetAllConsoles() throws Exception{
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




        mockMvc.perform(get("/consoles"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(consolesJson));

    }


      @Test
        public void ShouldAddConsoles() throws Exception{
            mockMvc.perform(post("/consoles")                            // Perform the POST request.
                    .content(inputConsolesString)
                    .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                    .andExpect(status().isCreated())
                    .andExpect(content().json(outputConsolesString));

    }

   @Test
   public void shouldGetConsoleById() throws Exception{
       Consoles consoles = new Consoles();
       consoles.setId(1);
       consoles.setModel("Gamecube");
       consoles.setManufacturer("Nintendo");
       consoles.setMemoryAmount("128gb");
       consoles.setPrice(new BigDecimal("199.02"));
       consoles.setProcessor("Intel");
       consoles.setQuantity(99);


       String consolesJson = mapper.writeValueAsString(consoles);

       mockMvc.perform(get("/consoles/" + consolesId))
               .andDo(print())
               .andExpect(status().isOk())
               .andExpect(content().json(consolesJson));

   }

   @Test
    public void shouldUpdateConsoles() throws Exception {
       Consoles outputConsoles = new Consoles();
       outputConsoles.setId(1);
       outputConsoles.setModel("Nvidia");
       outputConsoles.setManufacturer("Google");
       outputConsoles.setMemoryAmount("1tb");
       outputConsoles.setPrice(new BigDecimal("399.99"));
       outputConsoles.setProcessor("Intel");
       outputConsoles.setQuantity(2);


       mockMvc.perform(put("/consoles/" + consolesId)
               .content(outputConsolesString)
               .contentType(MediaType.APPLICATION_JSON)
               )
               .andDo(print())
               .andExpect(status().isNoContent());
    }

  @Test
   public void shouldDeleteConsoles() throws Exception {
      mockMvc.perform(delete("/consoles/" + consolesId))
              .andDo(print())
              .andExpect(status().isNoContent());
 }

}
