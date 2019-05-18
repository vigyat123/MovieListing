package com.example.MovieListing.DTOs;

import java.util.Objects;
import java.util.Set;

public class Actors {
    private Set<Long> actorIdSet;

    public Set<Long> getActorIdSet() {
        return actorIdSet;
    }

    public void setActorIdSet(Set<Long> actorIdSet) {
        this.actorIdSet = actorIdSet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Actors actors = (Actors) o;
        return Objects.equals(actorIdSet, actors.actorIdSet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(actorIdSet);
    }
}
