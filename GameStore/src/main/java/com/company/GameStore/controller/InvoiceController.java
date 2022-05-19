package com.company.GameStore.controller;

import com.company.GameStore.exception.InvalidRequestException;
import com.company.GameStore.models.Invoices;
import com.company.GameStore.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class InvoiceController {

    @Autowired
    private ServiceLayer serviceLayer;

    @GetMapping(value = "/invoice")
    @ResponseStatus(HttpStatus.OK)
    public List<Invoices> getAllInvoices() {
        return serviceLayer.getAllInvoices();
    }

    @GetMapping("/invoices/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Invoices> getInvoiceById(@PathVariable int id) {

        return serviceLayer.getInvoicesById(id);
    }

    @PostMapping("/invoices")
    @ResponseStatus(HttpStatus.CREATED)
    public Invoices createInvoices(@Valid @RequestBody Invoices invoices) {
        return serviceLayer.addInvoices(invoices);
    }

    @PutMapping("/invoices/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Invoices updateInvoices(@RequestBody Invoices invoices) {
        return serviceLayer.updateInvoices(invoices);
    }
    @DeleteMapping("/invoices/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Invoices deleteInvoices(@PathVariable int id) {
        serviceLayer.deleteInvoices(id);
        return null;
    }
}
