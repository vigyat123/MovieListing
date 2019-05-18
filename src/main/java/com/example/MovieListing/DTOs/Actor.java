package com.example.MovieListing.DTOs;

import java.util.Objects;

public final class Actor {
    private Long identifier;
    private String name;
    private String sex;
    private String dateOfBirth;
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
        Actor actor = (Actor) o;
        return Objects.equals(identifier, actor.identifier) &&
                Objects.equals(name, actor.name) &&
                Objects.equals(sex, actor.sex) &&
                Objects.equals(dateOfBirth, actor.dateOfBirth) &&
                Objects.equals(bio, actor.bio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identifier, name, sex, dateOfBirth, bio);
    }

    @Override
    public String toString() {
        return "Actor{" +
                "identifier=" + identifier +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", bio='" + bio + '\'' +
                '}';
    }
}
