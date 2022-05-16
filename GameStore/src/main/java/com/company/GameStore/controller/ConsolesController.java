package com.company.GameStore.controller;

import com.company.GameStore.models.Consoles;
import com.company.GameStore.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

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

//    @RequestMapping(value="/console", method=RequestMethod.POST)
//    @ResponseStatus(HttpStatus.CREATED)
//    public Consoles createConsole(@RequestBody Consoles Consoles) {
//        return serviceLayer.saveConsole(Consoles);
//    }
//
//    @RequestMapping(value="/console/{manufacturer}", method=RequestMethod.GET)
//    @ResponseStatus(HttpStatus.OK)
//    public Consoles getConsoleById(@PathVariable String manufacturer) {
//        Consoles cvm = serviceLayer.findConsole(manufacturer);
//        if (cvm == null) {
//            throw new NoRecordFoundException("Console manufacturer " + manufacturer + " not found.");
//        }
//        return serviceLayer.findConsole(manufacturer);
//    }
//
//    @RequestMapping(value="/console/{manufacturer}", method=RequestMethod.PUT)
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void updateConsole(@PathVariable String manufacturer, @RequestBody Consoles cvm) {
////        if (cvm.getId() == 0) {
////            cvm.setId(manufacturer);
////        }
////        if (cvm.getId() != manufacturer) {
////            throw new InvalidRequestException("id in request body must match id in path");
////        }
////        serviceLayer.updateConsole(cvm);
//    }
//
//
//    @RequestMapping(value="/console/{manufacturer}", method=RequestMethod.DELETE)
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void deleteConsole(@PathVariable String manufacturer) {
//        serviceLayer.removeConsole(manufacturer);
//    }
}
