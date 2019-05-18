package com.example.MovieListing.DTOs;

import java.awt.image.BufferedImage;
import java.util.Objects;

public class Movie {
    private Long identifier;
    private String name;
    private String yearOfRelease;
    private String plot;
//    private BufferedImage poster;

    public Long getIdentifier() {
        return identifier;
    }

    public void setIdentifier(Long identifier) {
        this.identifier = identifier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(String yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(identifier, movie.identifier) &&
                Objects.equals(name, movie.name) &&
                Objects.equals(yearOfRelease, movie.yearOfRelease) &&
                Objects.equals(plot, movie.plot);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identifier, name, yearOfRelease, plot);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "identifier=" + identifier +
                ", name='" + name + '\'' +
                ", yearOfRelease='" + yearOfRelease + '\'' +
                ", plot='" + plot + '\'' +
                '}';
    }
}
