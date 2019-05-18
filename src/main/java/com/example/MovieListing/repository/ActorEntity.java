package com.example.MovieListing.repository;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "actor")
public class ActorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long identifier;

    @Column(name = "name")
    private String name;

    @Column(name = "sex")
    private String sex;

    @Column(name = "date_of_birth")
    private String dateOfBirth;

    @Column(name = "bio")
    private String bio;

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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActorEntity that = (ActorEntity) o;
        return Objects.equals(identifier, that.identifier) &&
                Objects.equals(name, that.name) &&
                Objects.equals(sex, that.sex) &&
                Objects.equals(dateOfBirth, that.dateOfBirth) &&
                Objects.equals(bio, that.bio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identifier, name, sex, dateOfBirth, bio);
    }
}
