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


    @RequestMapping(value = "/tshirt", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Tshirts> getAllTshirts() { return serviceLayer.getAllTshirts();

    }}

//    @RequestMapping(value = "/tshirt", method = RequestMethod.POST)
//    @ResponseStatus(HttpStatus.CREATED)
//    public Tshirts createTshirt(@RequestBody Tshirts tshirts) {
//        return serviceLayer.saveTshirt(tshirts);
//    }

//
//    @RequestMapping(value = "/tshirt/{color}", method = RequestMethod.POST)
//    @ResponseStatus(HttpStatus.CREATED)
//    public TshirtsViewModel createTshirtByColor(@PathVariable String color) {
//        return serviceLayar.saveTshirtByColor(tshirtsViewModel);
//    }
//
//    @RequestMapping(value = "/tshirt/{size}", method = RequestMethod.POST)
//    @ResponseStatus(HttpStatus.CREATED)
//    public TshirtsViewModel createTshirtBySize(@PathVariable String color) {
//        return serviceLayar.saveTshirtBySize(tshirtsViewModel);
//    }
//
//    @RequestMapping(value="/tshirt/{color}", method=RequestMethod.GET)
//    @ResponseStatus(HttpStatus.OK)
//    public TshirtsViewModel getTshirtByColor(@PathVariable String color) {
//        TshirtsViewModel tvm = serviceLayer.findTshirt(color);
//        if (tvm == null) {
//            throw new NoRecordFoundException("Tshirt color " + color + " not found.");
//        }
//        return serviceLayer.findTshirt(color);
//    }
//
//    @RequestMapping(value="/tshirt/{size}", method=RequestMethod.GET)
//    @ResponseStatus(HttpStatus.OK)
//    public TshirtsViewModel getTshirtBySize(@PathVariable String size) {
//        TshirtsViewModel tvm = serviceLayer.findTshirt(size);
//        if (tvm == null) {
//            throw new NoRecordFoundException("Tshirt size " + size + " not found.");
//        }
//        return serviceLayer.findTshirt(color);
//    }
//
//    @RequestMapping(value="/tshirt/{color}", method=RequestMethod.PUT)
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void updateTshirt(@PathVariable String color, @RequestBody TshirtsViewModel tvm) {
////        if (tvm.getId() == 0) {
////            tvm.setId(id);
////        }
////        if (tvm.getId() != id) {
////            throw new InvalidRequestException("id in request body must match id in path");
////        }
//        serviceLayer.updateTshirt(tvm);
//    }
//
//    @RequestMapping(value="/tshirt/{size}", method=RequestMethod.PUT)
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void updateTshirt(@PathVariable String size, @RequestBody TshirtsViewModel tvm) {
////        if (tvm.getId() == 0) {
////            tvm.setId(id);
////        }
////        if (tvm.getId() != id) {
////            throw new InvalidRequestException("id in request body must match id in path");
////        }
//        serviceLayer.updateTshirt(tvm);
//    }
//
//
//    @RequestMapping(value="/tshirt/{color}", method=RequestMethod.DELETE)
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void deleteTshirt(@PathVariable String color) {
//        serviceLayer.removeTshirt(color);
//    }
//
//
//    @RequestMapping(value="/tshirt/{size}", method=RequestMethod.DELETE)
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void deleteTshirt(@PathVariable String size) {
//        serviceLayer.removeTshirt(size);
//    }

