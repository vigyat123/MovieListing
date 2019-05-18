package com.example.MovieListing.repository;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "movie_actor_mapping")
public class MovieActorMappingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long identifier;

    @Column(name = "movie_id")
    private Long movieId;

    @Column(name = "actor_id")
    private Long actorId;

    public Long getIdentifier() {
        return identifier;
    }

    public void setIdentifier(Long identifier) {
        this.identifier = identifier;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public Long getActorId() {
        return actorId;
    }

    public void setActorId(Long actorId) {
        this.actorId = actorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieActorMappingEntity that = (MovieActorMappingEntity) o;
        return identifier.equals(that.identifier) &&
                movieId.equals(that.movieId) &&
                actorId.equals(that.actorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identifier, movieId, actorId);
    }
}
