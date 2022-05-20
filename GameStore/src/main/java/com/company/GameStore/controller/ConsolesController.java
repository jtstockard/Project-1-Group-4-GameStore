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
    @ResponseStatus(HttpStatus.OK)              // ok tells the server nothing has changed prior after this request
    public List<Consoles> getAllConsoles() {
        return serviceLayer.findAllConsoles();
    }

    @RequestMapping(value="/consoles", method=RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)   //create is a status to show the data had been added
    public Consoles addConsoles(@RequestBody Consoles consoles) {

        return serviceLayer.addConsoles(consoles);
    }
    @RequestMapping(value="/consoles/{id}", method=RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Consoles getById(@PathVariable int id) {

        return serviceLayer.getAConsoles(id);


    }

    @RequestMapping(value="/consoles/manufacturer/{manufacturer}", method=RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)              //takes the variable out and puts them in a method
    public List<Consoles> getByManufacturer(@PathVariable String manufacturer) {

        return serviceLayer.getByManufacturer(manufacturer);


    }
    @RequestMapping(value = "/consoles/{id}", method =RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)  //nothing needs to be passed through, so it's no content
    public Consoles updateConsoles(@RequestBody Consoles consoles) {
        return (Consoles) serviceLayer.updateConsoles(consoles);
    }

    @RequestMapping(value = "/consoles/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Consoles deleteConsoles(@PathVariable int id) {
        serviceLayer.deleteConsoles(id);
        return null;
    }



}
