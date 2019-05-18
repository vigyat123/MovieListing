package com.example.MovieListing.mappers;

import com.example.MovieListing.DTOs.Movie;
import com.example.MovieListing.repository.MovieEntity;

public class MovieMapper {
    public static MovieEntity map(Movie movie){
        MovieEntity movieEntity = new MovieEntity();
        movieEntity.setName(movie.getName());
        movieEntity.setYearOfRelease(movie.getYearOfRelease());
        movieEntity.setPlot(movie.getPlot());
//        movieEntity.setposter(movie.getPoster());
        return movieEntity;
    }

    public static Movie map(MovieEntity movieEntity){
        Movie movie = new Movie();
        movie.setIdentifier(movieEntity.getIdentifier());
        movie.setName(movieEntity.getName());
        movie.setYearOfRelease(movieEntity.getYearOfRelease());
        movie.setPlot(movieEntity.getPlot());
//        movieEntity.setposter(movie.getPoster());
        return movie;
    }

    public static MovieEntity mapOverOldEntity(MovieEntity oldMovieEntity, MovieEntity newMovieEntity) {
        oldMovieEntity.setName(newMovieEntity.getName());
        oldMovieEntity.setYearOfRelease(newMovieEntity.getYearOfRelease());
        oldMovieEntity.setPlot(newMovieEntity.getPlot());
//        oldMovieEntity.setPoster(newMovieEntity.getPoster());
        return oldMovieEntity;
    }
}
