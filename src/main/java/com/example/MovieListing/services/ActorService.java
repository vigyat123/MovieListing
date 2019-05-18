package com.example.MovieListing.services;

import com.example.MovieListing.DTOs.Actor;
import com.example.MovieListing.exceptions.ElementNotFoundException;
import com.example.MovieListing.mappers.ActorMapper;
import com.example.MovieListing.repository.ActorEntity;
import com.example.MovieListing.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ActorService {
    private final ActorRepository actorRepository;

    @Autowired
    public ActorService(final ActorRepository actorRepository) {
        super();
        this.actorRepository = actorRepository;
    }

    public void createActor(Actor actor){
        ActorEntity actorEntity;

        actorEntity = ActorMapper.map(actor);
        actorRepository.save(actorEntity);
    }

    public void editActor(Long identifier, Actor updatedActor){
        ActorEntity newActorEntity;
        ActorEntity updatedActorEntity = ActorMapper.map(updatedActor);
        Optional<ActorEntity> optionalActorEntity = actorRepository.findByIdentifier(identifier);
        newActorEntity = ActorMapper.mapOverOldEntity(optionalActorEntity.get(), updatedActorEntity);
        actorRepository.save(newActorEntity);
    }

    public List<Actor> getAllActors() {
        List<ActorEntity> actorEntities= actorRepository.findAll();
        List<Actor> actorList = new ArrayList<>();
        for (ActorEntity actorEntity : actorEntities){
            Actor actor = ActorMapper.map(actorEntity);
            actorList.add(actor);
        }
        return actorList;
    }

    public Boolean findIfActorExist(Long identifier) {
        Optional<ActorEntity> optionalActorEntity = actorRepository.findByIdentifier(identifier);
        if (!optionalActorEntity.isPresent()) {
            return false;
        }
        return true;
    }
}
