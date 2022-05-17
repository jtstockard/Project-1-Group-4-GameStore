package com.company.GameStore.controller;

import com.company.GameStore.models.Games;
import com.company.GameStore.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GamesController {

    @Autowired
    private ServiceLayer serviceLayer;

    @RequestMapping(value="/games", method= RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Games> getAllGames() {
        return serviceLayer.getAllGames();
    }

    @RequestMapping(value="/games", method=RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Games createGame(@RequestBody Games games) {
        return serviceLayer.addGames(games);
    }

    @RequestMapping(value="/games/{studio}", method=RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Games> getGamesByStudio(@PathVariable String studio) {
        return serviceLayer.findGamesByStudio();
    }

    @RequestMapping(value="/games/{rating}", method=RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Games> getGamesByRating(@PathVariable String rating) {

        return serviceLayer.findGamesByRating();
    }

    @RequestMapping(value="/games/{title}", method=RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Games> getGamesByTitle(@PathVariable String title) {

        return serviceLayer.findGamesByTitle();
    }



    @RequestMapping(value="/games/{studio}", method=RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public List<Games> updateGamesByStudio(@RequestBody String studio){
        return serviceLayer.updateGamesByStudio();
    }

    @RequestMapping(value="/games/{rating}", method=RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public List<Games> updateGamesByRating(@PathVariable String rating) {
        return serviceLayer.updateGamesByRating();
    }

    @RequestMapping(value="/games/{title}", method=RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public List<Games> updateGamesByTitle(@PathVariable String title) {
        return serviceLayer.updateGamesByTitle();
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

    @RequestMapping(value="/games/{title}", method=RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public List<Games> deleteGamesByTitle(@PathVariable String title) {
        return serviceLayer.removeGamesByTitle();

    }
    }


