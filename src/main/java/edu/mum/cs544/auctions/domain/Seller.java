package edu.mum.cs544.auctions.domain;

import javax.persistence.Entity;

/**
 * Created by Subhechha Bista on 6/19/2017.
 */
@Entity
public class Seller extends User {

    private int id;
    private int stars;

    public Seller() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }
}
