package com.gfg;

import java.util.Comparator;

public class Movie implements Comparable {
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    Integer id;
    Integer userRating;
    Integer criticRating;

    public Movie(Integer id, Integer userRating, Integer criticRating) {
        this.id =id;
        this.userRating = userRating;
        this.criticRating = criticRating;
    }

    public Integer getUserRating() {
        return userRating;
    }

    public void setUserRating(Integer userRating) {
        this.userRating = userRating;
    }

    public Integer getCriticRating() {
        return criticRating;
    }

    public void setCriticRating(Integer criticRating) {
        this.criticRating = criticRating;
    }

    @Override
    public int compareTo(Object o) {
        return ((Movie) o).getUserRating()-this.getUserRating();
    }
}
