package com.company.GameStore.controller;

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
        return serviceLayer.getAllTshirts();

    }

    @RequestMapping(value = "/tshirts", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Tshirts createTshirt(@RequestBody Tshirts tshirts ) {
        return serviceLayer.addATshirts(tshirts);
    }

    @RequestMapping(value="/tshirts/color/{color}", method=RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Tshirts> getTshirtsByColor(@PathVariable String color) {

        return serviceLayer.getTshirtsByColor(color);
    }

    @RequestMapping(value="/tshirts/size/{size}", method=RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Tshirts> getTshirtBySize(@PathVariable String size) {

        return serviceLayer.getTshirtsBySize(size);
    }
    @RequestMapping(value="/tshirts/{id}", method=RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Tshirts getTshirtById(@PathVariable int id) {

        return serviceLayer.getATshirtsById(id);
    }

    @RequestMapping(value="/tshirts/{id}", method=RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Tshirts updateTshirtsById(@RequestBody Tshirts tshirts) {
        return serviceLayer.updateTshirts(tshirts);
    }

    @RequestMapping(value="/tshirts/{id}", method=RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Tshirts deleteTshirtsById(@PathVariable int id) {
        serviceLayer.deleteTshirts(id);
        return null;
    }
}

