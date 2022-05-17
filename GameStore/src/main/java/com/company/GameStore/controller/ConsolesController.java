package com.company.GameStore.controller;

import com.company.GameStore.models.Consoles;
import com.company.GameStore.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ConsolesController {


    @Autowired
    private ServiceLayer serviceLayer;


    @RequestMapping(value = "/consoles", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Consoles> getAllConsoles() {
        return serviceLayer.findAllConsoles();
    }

    @RequestMapping(value="/consoles", method=RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Consoles createConsole(@RequestBody Consoles consoles) {
        return serviceLayer.addConsoles(consoles);
    }

    @RequestMapping(value="/consoles/{manufacturer}", method=RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Consoles> getByManufacturer(@PathVariable String manufacturer) {

        return serviceLayer.getByManufacturer(manufacturer);


    }
    @RequestMapping(value = "/consoles", method =RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public Consoles updateConsoles(@RequestBody Consoles consoles) {
        return serviceLayer.updateConsoles(consoles);
    }

    @RequestMapping(value = "/consoles/{manufacturer}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public Consoles deleteConsole(@PathVariable int id) {
        return serviceLayer.deleteConsole(id);
    }



}
