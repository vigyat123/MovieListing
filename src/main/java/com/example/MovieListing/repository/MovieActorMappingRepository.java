package com.example.MovieListing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieActorMappingRepository extends JpaRepository<MovieActorMappingEntity, Long> {
    Optional<MovieActorMappingEntity> findByMovieIdAndActorId(Long movieId, Long actorId);

    List<MovieActorMappingEntity> findByMovieId(Long movieId);
}
