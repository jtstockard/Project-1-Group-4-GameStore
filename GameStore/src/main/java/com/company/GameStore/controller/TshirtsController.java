package com.company.GameStore.controller;

import com.company.GameStore.models.Consoles;
import com.company.GameStore.models.Tshirts;
import com.company.GameStore.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TshirtsController {

    @Autowired
    private ServiceLayer serviceLayer;

    @RequestMapping(value = "/tshirts", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Tshirts> getAllTshirts() {
        return serviceLayer.findAllTshirts();

    }

    @RequestMapping(value = "/tshirts", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public List<Tshirts> createTshirt(@RequestBody Tshirts tshirts ) {
        return serviceLayar.saveTshirt(tshirts);
    }

    @RequestMapping(value="/tshirts/{color}", method=RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Tshirts> getTshirtsByColor(@PathVariable String color) {

        return serviceLayer.findTshirtByColor(color);
    }

    @RequestMapping(value="/tshirts/{size}", method=RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Tshirts> getTshirtBySize(@PathVariable String size) {

        return serviceLayer.findTshirtBySize(size);
    }

    @RequestMapping(value = "/tshirts", method =RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public List<Tshirts> updateTshirts(@RequestBody Tshirts tshirts) {
        return serviceLayer.updateTshirts(tshirts);
    }


    @RequestMapping(value="/tshirt/{color}", method=RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTshirt(@PathVariable String color) {
        serviceLayer.removeTshirt(color);
    }


    @RequestMapping(value="/tshirt/{size}", method=RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTshirt(@PathVariable String size) {
        serviceLayer.removeTshirt(size);
    }
}
