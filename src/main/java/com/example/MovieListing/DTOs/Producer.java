package com.example.MovieListing.DTOs;

import java.util.Objects;

public final class Producer {
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
        Producer producer = (Producer) o;
        return Objects.equals(identifier, producer.identifier) &&
                Objects.equals(name, producer.name) &&
                Objects.equals(sex, producer.sex) &&
                Objects.equals(dateOfBirth, producer.dateOfBirth) &&
                Objects.equals(bio, producer.bio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identifier, name, sex, dateOfBirth, bio);
    }

    @Override
    public String toString() {
        return "Producer{" +
                "identifier=" + identifier +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", bio='" + bio + '\'' +
                '}';
    }
}
