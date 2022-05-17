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

    @RequestMapping(value="/games/{studio}", method=RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public List<Games> deleteGamesByStudio(@PathVariable String studio) {
        return serviceLayer.removeGamesByStudio();
    }

    @RequestMapping(value="/games/{rating}", method=RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public List<Games> deleteGamesByRating(@PathVariable String rating) {
        return serviceLayer.removeGamesByRating();
    }

}
