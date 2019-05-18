package com.example.MovieListing.repository;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "movie_producer_mapping")
public class MovieProducerMappingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long identifier;

    @Column(name = "movie_id")
    private Long movieId;

    @Column(name = "producer_id")
    private Long producerId;

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

    public Long getProducerId() {
        return producerId;
    }

    public void setProducerId(Long producerId) {
        this.producerId = producerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieProducerMappingEntity that = (MovieProducerMappingEntity) o;
        return Objects.equals(identifier, that.identifier) &&
                Objects.equals(movieId, that.movieId) &&
                Objects.equals(producerId, that.producerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identifier, movieId, producerId);
    }
}
