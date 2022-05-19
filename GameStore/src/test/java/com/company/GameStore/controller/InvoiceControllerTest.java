package com.company.GameStore.controller;

import com.company.GameStore.models.Invoices;
import com.company.GameStore.service.ServiceLayer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.applet2.AppletParameters;
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
import java.util.*;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(InvoiceController.class)
public class InvoiceControllerTest {
    @MockBean
    ServiceLayer serviceLayer;

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper mapper = new ObjectMapper();

    private Invoices inputInvoices;

    private Invoices outputInvoices;

    private String inputInvoicesString;

    private String outputInvoicesString;

    private List<Invoices> allInvoices;

    private int invoicesId = 3;

    private int nonExistentAlbumId = 999;

    @Before
    public void setUp() throws Exception {
        Invoices invoices = new Invoices(3,"Johnny Carson","402 Hollywood Blvd","Los Angeles","CA","90210","Game",3,new BigDecimal("493.29"),new BigDecimal("493.34"),new BigDecimal(".05"), new BigDecimal("1.49"),10, new BigDecimal("494.83"));
        Invoices invoices1 = new Invoices(4,"Max Gosling","1232 Mason Rd","Chicago","IL","69420","Console",2,new BigDecimal("599.99"),new BigDecimal("600.04"),new BigDecimal(".05"), new BigDecimal("14.99"),100, new BigDecimal("615.94"));


        List<Invoices> invoicesList = new ArrayList<>();
        invoicesList.add(invoices);
        invoicesList.add(invoices1);
        doReturn(invoicesList).when(serviceLayer).getAllInvoices();
        inputInvoices = new Invoices(3,"Johnny Carson","402 Hollywood Blvd","Los Angeles","CA","90210","Game",3,new BigDecimal("493.29"),new BigDecimal("493.34"),new BigDecimal(".05"), new BigDecimal("1.49"),10, new BigDecimal("494.83"));
        outputInvoices = new Invoices(3,"Johnny Carson","402 Hollywood Blvd","Los Angeles","CA","90210","Game",3,new BigDecimal("493.29"),new BigDecimal("493.34"),new BigDecimal(".05"), new BigDecimal("1.49"),10, new BigDecimal("494.83"));
        inputInvoicesString = mapper.writeValueAsString(inputInvoices);
        outputInvoicesString = mapper.writeValueAsString(outputInvoices);
        allInvoices = Arrays.asList(outputInvoices);


        when(serviceLayer.getAllInvoices()).thenReturn(invoicesList);
        when(serviceLayer.getInvoicesById(invoicesId)).thenReturn(Optional.of(outputInvoices));
        when(serviceLayer.addInvoices(inputInvoices)).thenReturn(outputInvoices);
    }



    @Test
    public void shouldReturnAllInvoicesWithStatus200() throws Exception{
        Invoices invoices = new Invoices();
        invoices.setName("Johnny Carson");
        invoices.setStreet("402 Hollywood Blvd");
        invoices.setCity("Los Angeles");
        invoices.setStreet("CA");
        invoices.setZipCode("90210");
        invoices.setItemType("Game");
        invoices.setItemId(3);
        invoices.setUnitPrice(new BigDecimal("493.29"));
        invoices.setSubTotal(new BigDecimal("493.34"));
        invoices.setTaxTotal(new BigDecimal(".05"));
        invoices.setProcessing(new BigDecimal("1.49"));
        invoices.setQuantity(10);
        invoices.setTotal(new BigDecimal("494.83"));

        Invoices invoices1 = new Invoices();
        invoices1.setName("Johnny Carson");
        invoices1.setStreet("402 Hollywood Blvd");
        invoices1.setCity("Los Angeles");
        invoices1.setStreet("California");
        invoices1.setZipCode("90210");
        invoices1.setItemType("Game");
        invoices1.setItemId(3);
        invoices1.setUnitPrice(new BigDecimal("493.29"));
        invoices1.setSubTotal(new BigDecimal("493.34"));
        invoices1.setTaxTotal(new BigDecimal(".05"));
        invoices1.setProcessing(new BigDecimal("1.49"));
        invoices1.setQuantity(10);
        invoices1.setTotal(new BigDecimal("494.83"));

        List<Invoices> invoicesList = new ArrayList<>();
        invoicesList.add(invoices);
        invoicesList.add(invoices1);
        doReturn(invoicesList).when(serviceLayer).getAllInvoices();
        String invoicesJson = mapper.writeValueAsString(invoicesList);

        mockMvc.perform(get("/invoices"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(invoicesJson));

    }

    @Test
    public void shouldReturnInvoiceByIdWithStatus200() throws Exception{
        Invoices invoices = new Invoices();
        invoices.setId(3);
        invoices.setName("Johnny Carson");
        invoices.setStreet("402 Hollywood Blvd");
        invoices.setCity("Los Angeles");
        invoices.setState("CA");
        invoices.setZipCode("90210");
        invoices.setItemType("Game");
        invoices.setItemId(3);
        invoices.setUnitPrice(new BigDecimal("493.29"));
        invoices.setSubTotal(new BigDecimal("493.34"));
        invoices.setTaxTotal(new BigDecimal(".05"));
        invoices.setProcessing(new BigDecimal("1.49"));
        invoices.setQuantity(10);
        invoices.setTotal(new BigDecimal("494.83"));
        String invoicesJsonString = mapper.writeValueAsString(invoices);

        mockMvc.perform(get("/invoices/" + invoicesId))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(invoicesJsonString));
    }

    @Test
    public void shouldReturn404StatusCodeIfNoInvoiceById() throws Exception{
            mockMvc.perform(get("/invoices/" + nonExistentAlbumId))
                    .andDo(print())
                    .andExpect(status().isOk());
    }

    @Test
    public void shouldPostRequestToInvoicesWithStatus201() throws Exception {
        mockMvc.perform(post("/invoices")
                        .content(inputInvoicesString)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(outputInvoicesString));
    }

}