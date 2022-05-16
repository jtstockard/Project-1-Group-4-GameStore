package com.company.GameStore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ConsolesController {


    @Autowired
    private ServiceLayer serviceLayer;


    @RequestMapping(value="/console", method= RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<ConsoleViewModel> getAllConsoles() {
        return serviceLayer.findAllConsoles();
    }

    @RequestMapping(value="/console", method=RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public ConsoleViewModel createConsole(@RequestBody ConsoleViewModel consoleViewModel) {
        return serviceLayer.saveConsole(consoleViewModel);
    }

    @RequestMapping(value="/console/{manufacturer}", method=RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public ConsoleViewModel getConsoleById(@PathVariable String manufacturer) {
        ConsoleViewModel cvm = serviceLayer.findConsole(manufacturer);
        if (cvm == null) {
            throw new NoRecordFoundException("Console manufacturer " + manufacturer + " not found.");
        }
        return serviceLayer.findConsole(manufacturer);
    }

    @RequestMapping(value="/console/{manufacturer}", method=RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateConsole(@PathVariable String manufacturer, @RequestBody ConsoleViewModel cvm) {
//        if (cvm.getId() == 0) {
//            cvm.setId(manufacturer);
//        }
//        if (cvm.getId() != manufacturer) {
//            throw new InvalidRequestException("id in request body must match id in path");
//        }
//        serviceLayer.updateConsole(cvm);
    }


    @RequestMapping(value="/console/{manufacturer}", method=RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteConsole(@PathVariable String manufacturer) {
        serviceLayer.removeConsole(manufacturer);
    }
}
