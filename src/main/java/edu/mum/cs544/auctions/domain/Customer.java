package edu.mum.cs544.auctions.domain;

/**
 * Created by Subhechha Bista on 6/19/2017.
 */

public class Customer extends User {

    private int id;
    private int winsCount;

    public Customer(){

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
