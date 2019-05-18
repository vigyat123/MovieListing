package com.example.MovieListing.services;

import com.example.MovieListing.DTOs.*;
import com.example.MovieListing.exceptions.DataAlreadyAvailableException;
import com.example.MovieListing.mappers.ActorMapper;
import com.example.MovieListing.mappers.MovieMapper;
import com.example.MovieListing.mappers.ProducerMapper;
import com.example.MovieListing.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    private final MovieRepository movieRepository;
    private final MovieProducerMappingRepository movieProducerMappingRepository;
    private final MovieActorMappingRepository movieActorMappingRepository;
    private final ProducerRepository producerRepository;
    private final ActorRepository actorRepository;

    @Autowired
    public MovieService(final MovieRepository movieRepository,
                        final MovieProducerMappingRepository movieProducerMappingRepository,
                        final MovieActorMappingRepository movieActorMappingRepository,
                        final ProducerRepository producerRepository,
                        final ActorRepository actorRepository) {
        super();
        this.movieRepository = movieRepository;
        this.movieProducerMappingRepository = movieProducerMappingRepository;
        this.movieActorMappingRepository = movieActorMappingRepository;
        this.producerRepository = producerRepository;
        this.actorRepository = actorRepository;
    }

    public void createMovie(Movie movie){
        MovieEntity movieEntity;

        movieEntity = MovieMapper.map(movie);
        movieRepository.save(movieEntity);
    }

    public Boolean findIfMovieExist(Long identifier) {
        Optional<MovieEntity> optionalMovieEntity = movieRepository.findByIdentifier(identifier);
        if (!optionalMovieEntity.isPresent()) {
            return false;
        }
        return true;
    }

    public void editMovie(Long identifier, Movie updatedMovie){
        MovieEntity newMovieEntity;
        MovieEntity updatedMovieEntity = MovieMapper.map(updatedMovie);
        Optional<MovieEntity> optionalMovieEntity = movieRepository.findByIdentifier(identifier);
        newMovieEntity = MovieMapper.mapOverOldEntity(optionalMovieEntity.get(), updatedMovieEntity);
        movieRepository.save(newMovieEntity);
    }

    public void addProducerToMovie(final Long movieId, final Long producerId) throws Exception {
        MovieProducerMappingEntity movieProducerMappingEntity = new MovieProducerMappingEntity();
        Optional<MovieProducerMappingEntity> optionalMovieProducerMappingEntity = movieProducerMappingRepository.findByMovieId(movieId);
        if (!optionalMovieProducerMappingEntity.isPresent()) {
            movieProducerMappingEntity.setMovieId(movieId);
        }else {
            throw new DataAlreadyAvailableException("Movie can have single producer");
        }
        movieProducerMappingEntity.setProducerId(producerId);
        movieProducerMappingRepository.save(movieProducerMappingEntity);
    }

    public void addActorsToMovie(Long movieId, Actors actors) throws Exception {
        for (Long actorId : actors.getActorIdSet()){
            MovieActorMappingEntity movieActorMappingEntity = new MovieActorMappingEntity();
            movieActorMappingEntity.setMovieId(movieId);
            movieActorMappingEntity.setActorId(actorId);
            Optional<MovieActorMappingEntity> movieActorMappingEntityOptional= movieActorMappingRepository.findByMovieIdAndActorId(movieId, actorId);
         if (movieActorMappingEntityOptional.isPresent()){
                 throw new DataAlreadyAvailableException("The actor for the given movie is already registered");
         }
         movieActorMappingRepository.save(movieActorMappingEntity);
        }
    }

    public List<MovieDetails> getAllMovieDetails() {
        List<MovieDetails> movieDetailsList = new ArrayList<>();

        List<MovieEntity> movieEntities = movieRepository.findAll();
        for (MovieEntity movieEntity :movieEntities){
            Movie movie = MovieMapper.map(movieEntity);
            Producer producer = new Producer();
            Optional<MovieProducerMappingEntity> optionalMovieProducerMappingEntity = movieProducerMappingRepository.findByMovieId(movie.getIdentifier());
            if (optionalMovieProducerMappingEntity.isPresent()){
                Optional<ProducerEntity> optionalProducerEntity = producerRepository.findByIdentifier(optionalMovieProducerMappingEntity.get().getProducerId());
                if (optionalProducerEntity.isPresent()) {
                    producer = ProducerMapper.map(optionalProducerEntity.get());
                }
            }

            List<Actor> actorList = new ArrayList<>();
            List<MovieActorMappingEntity> movieActorMappingEntities = movieActorMappingRepository.findByMovieId(movie.getIdentifier());
            for (MovieActorMappingEntity movieActorMappingEntity : movieActorMappingEntities){
                Optional<ActorEntity> optionalActorEntity = actorRepository.findByIdentifier(movieActorMappingEntity.getActorId());
                if (optionalActorEntity.isPresent()){
                    Actor actor = ActorMapper.map(optionalActorEntity.get());
                    actorList.add(actor);
                }
            }
            MovieDetails movieDetails = new MovieDetails();
            movieDetails.setMovie(movie);
            movieDetails.setProducer(producer);
            movieDetails.setActors(actorList);
            movieDetailsList.add(movieDetails);
        }
        return movieDetailsList;
    }
}
