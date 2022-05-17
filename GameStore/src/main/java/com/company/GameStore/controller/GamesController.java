package com.company.GameStore.controller;

import com.company.GameStore.models.Games;
import com.company.GameStore.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GamesController {

    @Autowired
    private ServiceLayer serviceLayer;

    @RequestMapping(value="/game", method= RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Games> getAllGames() {
        return serviceLayer.findAllGames();
    }
    }


//    @RequestMapping(value="/game", method=RequestMethod.POST)
//    @ResponseStatus(HttpStatus.CREATED)
//    public GamesViewModel createAlbum(@RequestBody GamesViewModel gameViewModel) {
//        return serviceLayer.saveGame(gameViewModel);
//    }

//    @RequestMapping(value="/game/{studio}", method=RequestMethod.GET)
//    @ResponseStatus(HttpStatus.OK)
//    public GamesViewModel getGameByStudio(@PathVariable String studio) {
//        GamesViewModel gvm = serviceLayer.findGames(studio);
//        if (gvm == null) {
//            throw new NoRecordFoundException("Game studio " + studio + " not found.");
//        }
//        return serviceLayer.findGame(studio);
//    }

//    @RequestMapping(value="/game/{rating}", method=RequestMethod.GET)
//    @ResponseStatus(HttpStatus.OK)
//    public GamesViewModel getGameByRating(@PathVariable String rating) {
//        GamesViewModel gvm = serviceLayer.findGames(rating);
//        if (gvm == null) {
//            throw new NoRecordFoundException("Game ESRB rating " + rating + " not found.");
//        }
//        return serviceLayer.findGame(rating);
//    }

//    @RequestMapping(value="/game/{title}", method=RequestMethod.GET)
//    @ResponseStatus(HttpStatus.OK)
//    public GamesViewModel getGameByTitle(@PathVariable String title) {
//        GamesViewModel gvm = serviceLayer.findGames(title);
//        if (gvm == null) {
//            throw new NoRecordFoundException("Game title " + title + " not found.");
//        }
//        return serviceLayer.findGame(title);
//    }



//    @RequestMapping(value="/game/{studio}", method=RequestMethod.PUT)
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void updateGame(@PathVariable String studio, @RequestBody GamesViewModel gvm) {
//
//    }

//    @RequestMapping(value="/game/{rating}", method=RequestMethod.PUT)
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void updateGame(@PathVariable String rating, @RequestBody GamesViewModel gvm) {
//
//        if (gvm.getRating() == null) {
////                gvm.setRating(rating);
////            }
////            if (gvm.getRating() != rating) {
//                throw new InvalidRequestException("id in request body must match id in path");
//            }
//            serviceLayer.updateGame(gvm);
//        }

//    }

//    @RequestMapping(value="/game/{title}", method=RequestMethod.PUT)
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void updateGame(@PathVariable String title, @RequestBody GamesViewModel gvm) {
//
//    }


//        @RequestMapping(value="/game/{id}", method=RequestMethod.PUT)
//        @ResponseStatus(HttpStatus.NO_CONTENT)
//        public void updateGame(@PathVariable int id, @RequestBody GamesViewModel gvm) {
//            if (gvm.getId() == 0) {
//                gvm.setId(id);
//            }
//            if (gvm.getId() != id) {
//                throw new InvalidRequestException("id in request body must match id in path");
//            }
//            serviceLayer.updateGame(gvm);
//        }
//
//    @RequestMapping(value="/game/{studio}", method=RequestMethod.DELETE)
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void deleteGameByStudio(@PathVariable String studio) {
//        serviceLayer.removeGame(studio);
//    }
//
//    @RequestMapping(value="/game/{rating}", method=RequestMethod.DELETE)
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void deleteGameByRating(@PathVariable String rating) {
//        serviceLayer.removeGame(rating);
//    }
//
//    @RequestMapping(value="/game/{title}", method=RequestMethod.DELETE)
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void deleteGameByTitle(@PathVariable String title) {
//        serviceLayer.removeGame(title);
//    }
//
//    }


