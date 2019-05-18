package com.example.MovieListing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieProducerMappingRepository extends JpaRepository<MovieProducerMappingEntity, Long> {
    Optional<MovieProducerMappingEntity> findByMovieId(Long movieId);
}
