package edu.mum.cs544.auctions.domain;

import javax.persistence.Entity;

/**
 * Created by Subhechha Bista on 6/19/2017.
 */
@Entity
public class Seller extends User {

    private int stars;

    public Seller() {
    }

    public Seller(String username, String password, String role) {
        super(username, password, role);
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }
}
