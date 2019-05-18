package com.example.MovieListing.DTOs;

import java.util.List;
import java.util.Objects;

public class MovieDetails {
    private Movie movie;
    private List<Actor> actors;
    private Producer producer;

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieDetails that = (MovieDetails) o;
        return movie.equals(that.movie) &&
                actors.equals(that.actors) &&
                producer.equals(that.producer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movie, actors, producer);
    }
}
