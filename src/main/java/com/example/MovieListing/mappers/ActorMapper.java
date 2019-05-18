package com.example.MovieListing.mappers;

import com.example.MovieListing.DTOs.Actor;
import com.example.MovieListing.repository.ActorEntity;

public class ActorMapper {

    public static ActorEntity map(Actor actor){
        ActorEntity actorEntity = new ActorEntity();
        actorEntity.setName(actor.getName());
        actorEntity.setSex(actor.getSex());
        actorEntity.setDateOfBirth(actor.getDateOfBirth());
        actorEntity.setBio(actor.getBio());
        return actorEntity;
    }

    public static Actor map(ActorEntity actorEntity){
        Actor actor = new Actor();
        actor.setIdentifier(actorEntity.getIdentifier());
        actor.setName(actorEntity.getName());
        actor.setSex(actorEntity.getSex());
        actor.setDateOfBirth(actorEntity.getDateOfBirth());
        actor.setBio(actorEntity.getBio());
        return actor;
    }

    public static ActorEntity mapOverOldEntity(ActorEntity oldActorEntity, ActorEntity newActorEntity) {
        oldActorEntity.setName(newActorEntity.getName());
        oldActorEntity.setSex(newActorEntity.getSex());
        oldActorEntity.setDateOfBirth(newActorEntity.getDateOfBirth());
        oldActorEntity.setBio(newActorEntity.getBio());
        return oldActorEntity;
    }
}
