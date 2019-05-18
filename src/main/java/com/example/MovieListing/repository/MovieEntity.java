package com.example.MovieListing.repository;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "movie")
public class MovieEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long identifier;

    @Column(name = "name")
    private String name;

    @Column(name = "year_of_release")
    private String yearOfRelease;

    @Column(name = "plot")
    private String plot;

    /*@Column(name = "poster")
    private String poster;*/

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
        MovieEntity that = (MovieEntity) o;
        return Objects.equals(identifier, that.identifier) &&
                Objects.equals(name, that.name) &&
                Objects.equals(yearOfRelease, that.yearOfRelease) &&
                Objects.equals(plot, that.plot);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identifier, name, yearOfRelease, plot);
    }
}
