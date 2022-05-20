package com.company.GameStore.controller;

import com.company.GameStore.models.Games;
import com.company.GameStore.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//combines controller and responsebody
@RestController
public class GamesController {

    //lets java use auto wiring
    @Autowired
    private ServiceLayer serviceLayer;

    @RequestMapping(value="/games", method= RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Games> getAllGames() {

        return serviceLayer.getAllGames();
    }

    @RequestMapping(value="/games/{id}", method= RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Games getGamesById(@PathVariable int id) {

       return serviceLayer.getGamesById(id);
    }

    @RequestMapping(value="/games", method=RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Games createGame(@RequestBody Games games) {
        return serviceLayer.addGames(games);
    }

    @RequestMapping(value="/games/studio/{studio}", method=RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Games> getGamesByStudio(@PathVariable String studio) {
        return serviceLayer.getGamesByStudio(studio);

    }

    @RequestMapping(value="/games/rating/{rating}", method=RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Games> getGamesByRating(@PathVariable String rating) {

        return serviceLayer.getGamesByErsbRating(rating);
    }

    @RequestMapping(value="/games/title/{title}", method=RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Games> getGamesByTitle(@PathVariable String title) {
        return serviceLayer.getGamesByTitle(title);
    }



    @RequestMapping(value="/games/{id}", method=RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Games updateGames(@RequestBody Games games){
        return (Games) serviceLayer.updateGames(games);
    }

    @RequestMapping(value="/games/{id}", method=RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Games deleteGames(@PathVariable int id) {
        serviceLayer.deleteGames(id);
        return null;
    }
}



