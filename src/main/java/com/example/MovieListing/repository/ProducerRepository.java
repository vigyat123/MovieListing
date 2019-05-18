package com.example.MovieListing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProducerRepository extends JpaRepository<ProducerEntity, Long> {
    Optional<ProducerEntity> findByIdentifier(Long producerId);
}
