package com.example.MovieListing.services;

import com.example.MovieListing.DTOs.Actor;
import com.example.MovieListing.DTOs.Producer;
import com.example.MovieListing.mappers.ActorMapper;
import com.example.MovieListing.mappers.ProducerMapper;
import com.example.MovieListing.repository.ActorEntity;
import com.example.MovieListing.repository.ActorRepository;
import com.example.MovieListing.repository.ProducerEntity;
import com.example.MovieListing.repository.ProducerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProducerService {
    private final ProducerRepository producerRepository;

    @Autowired
    public ProducerService(ProducerRepository producerRepository) {
        super();
        this.producerRepository = producerRepository;
    }

    public void createProducer(Producer producer){
        ProducerEntity producerEntity;

        producerEntity = ProducerMapper.map(producer);
        producerRepository.save(producerEntity);
    }

    public void editProducer(Long identifier, Producer updatedProducer){
        ProducerEntity newProducerEntity;
        ProducerEntity updatedProducerEntity = ProducerMapper.map(updatedProducer);
        Optional<ProducerEntity> optionalProducerEntity = producerRepository.findByIdentifier(identifier);
        newProducerEntity = ProducerMapper.mapOverOldEntity(optionalProducerEntity.get(), updatedProducerEntity);
        producerRepository.save(newProducerEntity);
    }

    public Boolean findIfProducerExist(Long identifier) {
        Optional<ProducerEntity> optionalProducerEntity = producerRepository.findByIdentifier(identifier);
        if (!optionalProducerEntity.isPresent()) {
            return false;
        }
        return true;
    }

    public List<Producer> getAllProducers() {
        List<ProducerEntity> producerEntities= producerRepository.findAll();
        List<Producer> producerList = new ArrayList<>();
        for (ProducerEntity producerEntity : producerEntities){
            Producer producer = ProducerMapper.map(producerEntity);
            producerList.add(producer);
        }
        return producerList;
    }
}
