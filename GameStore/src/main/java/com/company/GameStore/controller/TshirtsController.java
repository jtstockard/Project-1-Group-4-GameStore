package com.company.GameStore.controller;

import com.company.GameStore.models.Consoles;
import com.company.GameStore.models.Games;
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
        return serviceLayer.findAll();

    }

    @RequestMapping(value = "/tshirts", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public List<Tshirts> createTshirt(@RequestBody Tshirts tshirts ) {
        return serviceLayer.saveTshirt();
    }

    @RequestMapping(value="/tshirts/{color}", method=RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Tshirts> getTshirtsByColor(@PathVariable String color) {

        return serviceLayer.findTshirtsByColor();
    }

    @RequestMapping(value="/tshirts/{size}", method=RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Tshirts> getTshirtBySize(@PathVariable String size) {

        return serviceLayer.findTshirtsBySize();
    }

    @RequestMapping(value="/tshirts/{color}", method=RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public List<Tshirts> updateTshirtsByColor(@PathVariable String color) {
        return serviceLayer.updateTshirtsByColor();
    }

    @RequestMapping(value="/tshirts/{size}", method=RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public List<Tshirts> updateTshirtsBySize(@PathVariable String size) {
        return serviceLayer.updateTshirtsBySize();
    }

    @RequestMapping(value="/tshirts/{color}", method=RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public List<Tshirts> deleteTshirtsByColor(@PathVariable String color) {
        return serviceLayer.removeTshirtsByColor();
    }

    @RequestMapping(value="/tshirts/{size}", method=RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public List<Tshirts> deleteTshirtsBySize(@PathVariable String size) {
        return serviceLayer.removeTshirtsBySize();
    }

}
