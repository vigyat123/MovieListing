package com.example.MovieListing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ActorRepository extends JpaRepository<ActorEntity, Long> {
    Optional<ActorEntity> findByIdentifier(Long identifier);
}
