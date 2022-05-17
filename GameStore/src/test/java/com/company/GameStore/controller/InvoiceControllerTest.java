package com.company.GameStore.controller;

import com.company.GameStore.models.Invoices;
import com.company.GameStore.service.ServiceLayer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(InvoiceController.class)
class InvoiceControllerTest {
    @MockBean
    ServiceLayer serviceLayer;

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper mapper = new ObjectMapper();

    Invoices expectedInvoices1;
    Invoices expectedInvoices2;
    Invoices inputInvoices1;
    List<Invoices> invoicesList;
    String expectedJson;
    String inputJson;

    @Before
    public void setUp(){
        expectedInvoices1 = new Invoices(3,"Johnny Carson","402 Hollywood Blvd","Los Angeles","California","90210","Game",3,6,new BigDecimal(493.29));
        expectedInvoices2 = new Invoices(4,"Ed McMahon","403 Hollywood Blvd","Los Angeles","California","90210","Console",7,2,new BigDecimal(1293.39));

        inputInvoices1 = new Invoices(3,"Johnny Carson","402 Hollywood Blvd","Los Angeles","California","90210","Game",3,6, new BigDecimal(493.29));

        invoicesList = Arrays.asList(expectedInvoices1, expectedInvoices2);

        when(serviceLayer.getAllInvoices()).thenReturn(invoicesList);
        when(serviceLayer.getInvoicesById(3)).thenReturn(Optional.of(expectedInvoices1));
        when(serviceLayer.addInvoices(inputInvoices1)).thenReturn(expectedInvoices1);
    }



    @Test
    public void shouldReturnAllInvoicesWithStatus200() throws Exception{
        expectedJson = mapper.writeValueAsString(invoicesList);

        mockMvc.perform(get("/invoices"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(expectedJson));

    }

    @Test
    public void shouldReturnInvoiceByIdWithStatus200() throws Exception{
        expectedJson = mapper.writeValueAsString(invoicesList);

        mockMvc.perform(get("/invoices/3"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(expectedJson));
    }
    
    @Test
    public void shouldReturn404StatusCodeIfNoInvoiceById() throws Exception{
        mockMvc.perform(get("/invoices/49494"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    public void shouldPostRequestToInvoicesWithStatus200() throws Exception{
        inputJson = mapper.writeValueAsString(inputInvoices1);
        expectedJson = mapper.writeValueAsString(expectedInvoices1);

        mockMvc.perform(post("/invoices")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(expectedJson));
    }

    @Test
    public void shouldReturnStatus422IfInvalidRequestBody() throws Exception{
        HashMap<String, Object> invalidRequest = new HashMap<>();
        invalidRequest.put("id", 740);
        invalidRequest.put("title", "Prototype 3");

        inputJson = mapper.writeValueAsString(invalidRequest);

        mockMvc.perform(post("/invoices")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }
}