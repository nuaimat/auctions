package edu.mum.cs544.auctions.domain;

import javax.persistence.Entity;

/**
 * Created by Subhechha Bista on 6/19/2017.
 */
@Entity
public class Customer extends User {

    private int id;
    private int winsCount;

    public Customer(){

    }

    public Customer(String username, String password, String role, int id, int winsCount) {
        super(username, password, role);
        this.id = id;
        this.winsCount = winsCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWinsCount() {
        return winsCount;
    }

    public void setWinsCount(int winsCount) {
        this.winsCount = winsCount;
    }
}
