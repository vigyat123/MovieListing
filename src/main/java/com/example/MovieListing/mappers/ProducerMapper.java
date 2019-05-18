package com.example.MovieListing.mappers;

import com.example.MovieListing.DTOs.Producer;
import com.example.MovieListing.repository.ProducerEntity;

public class ProducerMapper {
    public static ProducerEntity map(Producer producer){
        ProducerEntity producerEntity = new ProducerEntity();
        producerEntity.setName(producer.getName());
        producerEntity.setSex(producer.getSex());
        producerEntity.setDateOfBirth(producer.getDateOfBirth());
        producerEntity.setBio(producer.getBio());
        return producerEntity;
    }

    public static Producer map(ProducerEntity producerEntity){
        Producer producer = new Producer();
        producer.setIdentifier(producerEntity.getIdentifier());
        producer.setName(producerEntity.getName());
        producer.setSex(producerEntity.getSex());
        producer.setDateOfBirth(producerEntity.getDateOfBirth());
        producer.setBio(producerEntity.getBio());
        return producer;
    }

    public static ProducerEntity mapOverOldEntity(ProducerEntity oldProducerEntity, ProducerEntity newProducerEntity) {
        oldProducerEntity.setName(newProducerEntity.getName());
        oldProducerEntity.setSex(newProducerEntity.getSex());
        oldProducerEntity.setDateOfBirth(newProducerEntity.getDateOfBirth());
        oldProducerEntity.setBio(newProducerEntity.getBio());
        return oldProducerEntity;
    }
}
