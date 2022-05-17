package com.company.GameStore.controller;

import com.company.GameStore.models.Games;
import com.company.GameStore.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class GamesController {

    @Autowired
    private ServiceLayer serviceLayer;

    @RequestMapping(value="/games", method= RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Games> getAllGames() {
        return serviceLayer.getAllGames();
    }

    @RequestMapping(value="/games/{id}", method= RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Optional getAGamesById() {

        return serviceLayer.getAGamesById();
    }

    @RequestMapping(value="/games", method=RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Games createGame(@RequestBody Games games) {
        return serviceLayer.addGames(games);
    }

    @RequestMapping(value="/games/{studio}", method=RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Games> getGamesByStudio(@PathVariable String studio) {
        return serviceLayer.getGetGamesByStudio(studio);

    }

    @RequestMapping(value="/games/{rating}", method=RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Games> getGamesByRating(@PathVariable String rating) {

        return serviceLayer.getGamesByErsbRating(rating);
    }

    @RequestMapping(value="/games/{title}", method=RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Games> getGamesByTitle(@PathVariable String title) {
        return serviceLayer.getGetGamesByTitle(title);
    }



    @RequestMapping(value="/games/{studio}", method=RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public Games updateGames(@RequestBody Games games){
        return serviceLayer.updateGames(games);
    }

    @RequestMapping(value="/games/{title}", method=RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public Games deleteGames(@PathVariable int id) {
        serviceLayer.deleteGames(id);
        return deleteGames(id);
    }
}



