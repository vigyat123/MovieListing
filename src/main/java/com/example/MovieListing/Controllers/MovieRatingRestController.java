package com.example.MovieListing.Controllers;

import com.example.MovieListing.DTOs.*;
import com.example.MovieListing.exceptions.ElementNotFoundException;
import com.example.MovieListing.services.ActorService;
import com.example.MovieListing.services.MovieService;
import com.example.MovieListing.services.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class MovieRatingRestController {

    private final ActorService actorService;
    private final ProducerService producerService;
    private final MovieService movieService;

    @Autowired
    public MovieRatingRestController(final ActorService actorService,
                                     final ProducerService producerService,
                                     final MovieService movieService) {
        super();
        this.actorService = actorService;
        this.producerService = producerService;
        this.movieService = movieService;
    }

    @RequestMapping(
            value = "/createActor",
            method = RequestMethod.POST,
            consumes = MediaType.ALL_VALUE,
            produces = MediaType.ALL_VALUE
    )
    public @ResponseBody
    ResponseEntity<Void> createActor(@RequestBody @Valid final Actor actor){
        actorService.createActor(actor);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @RequestMapping(
            value = "/editActor/{identifier}",
            method = RequestMethod.PUT,
            consumes = MediaType.ALL_VALUE,
            produces = MediaType.ALL_VALUE
    )
    public @ResponseBody
    ResponseEntity<Void> editActor(@PathVariable("identifier") final Long identifier,
            @RequestBody @Valid final Actor updatedActor) throws Exception {
        if (actorService.findIfActorExist(identifier)){
            actorService.editActor(identifier,updatedActor);
        }
        else {throw new ElementNotFoundException("Element not found");
        }

        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @RequestMapping(
            value = "/createProducer",
            method = RequestMethod.POST,
            consumes = MediaType.ALL_VALUE,
            produces = MediaType.ALL_VALUE
    )
    public @ResponseBody
    ResponseEntity<Void> createProducer(@RequestBody @Valid final Producer producer){
        producerService.createProducer(producer);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @RequestMapping(
            value = "/editProducer/{identifier}",
            method = RequestMethod.PUT,
            consumes = MediaType.ALL_VALUE,
            produces = MediaType.ALL_VALUE
    )
    public @ResponseBody
    ResponseEntity<Void> editProducer(@PathVariable("identifier") final Long identifier,
                                   @RequestBody @Valid final Producer updatedProducer) throws Exception {
        if (producerService.findIfProducerExist(identifier)){
            producerService.editProducer(identifier,updatedProducer);
        }
        else {throw new ElementNotFoundException("Element not found");
        }

        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @RequestMapping(
            value = "/createMovie",
            method = RequestMethod.POST,
            consumes = MediaType.ALL_VALUE,
            produces = MediaType.ALL_VALUE
    )
    public @ResponseBody
    ResponseEntity<Void> createMovie(@RequestBody @Valid final Movie movie){
        movieService.createMovie(movie);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @RequestMapping(
            value = "/editMovie/{identifier}",
            method = RequestMethod.PUT,
            consumes = MediaType.ALL_VALUE,
            produces = MediaType.ALL_VALUE
    )
    public @ResponseBody
    ResponseEntity<Void> editMovie(@PathVariable("identifier") final Long identifier,
                                      @RequestBody @Valid final Movie updatedMovie) throws Exception {
        if (movieService.findIfMovieExist(identifier)){
            movieService.editMovie(identifier,updatedMovie);
        }
        else {throw new ElementNotFoundException("Element not found");
        }

        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @RequestMapping(
            value = "/addProducerToMovie/{movie_id}/{producer_id}",
            method = RequestMethod.POST,
            consumes = MediaType.ALL_VALUE,
            produces = MediaType.ALL_VALUE
    )
    public @ResponseBody
    ResponseEntity<Void> addProducerToMovie(@PathVariable("movie_id") final Long movieId,
                                            @PathVariable("producer_id") final Long producerId) throws Exception {
        movieService.addProducerToMovie(movieId, producerId);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @RequestMapping(
            value = "/addActorsToMovie/{movie_id}",
            method = RequestMethod.POST,
            consumes = MediaType.ALL_VALUE,
            produces = MediaType.ALL_VALUE
    )
    public @ResponseBody
    ResponseEntity<Void> addActorsToMovie(@PathVariable("movie_id") final Long movieId,
                                          @RequestBody @Valid final Actors actors) throws Exception {
        movieService.addActorsToMovie(movieId, actors);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @RequestMapping(
            value = "/getAllActors",
            method = RequestMethod.GET,
            consumes = MediaType.ALL_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Actor> getAllActors(){
        List<Actor> actorList;
        actorList = actorService.getAllActors();
        return actorList;
    }

    @RequestMapping(
            value = "/getAllProducers",
            method = RequestMethod.GET,
            consumes = MediaType.ALL_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Producer> getAllProducers(){
        List<Producer> producerList;
        producerList = producerService.getAllProducers();
        return producerList;
    }

    @RequestMapping(
            value = "/getAllMovieDetails",
            method = RequestMethod.GET,
            consumes = MediaType.ALL_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<MovieDetails> getAllMovieDetails(){
        List<MovieDetails> movieDetailsList = new ArrayList<>();
        movieDetailsList = movieService.getAllMovieDetails();
        return movieDetailsList;
    }
}
