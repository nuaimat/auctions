package edu.mum.cs544.auctions.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Subhechha Bista on 6/19/2017.
 */
@Entity
public class Address {

    @Id
    @GeneratedValue
    private int id;
    private String streetAddress1;
    private String getStreetAddress2;
    private String city;
    private int zip;
    private int country;

    public Address() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreetAddress1() {
        return streetAddress1;
    }

    public void setStreetAddress1(String streetAddress1) {
        this.streetAddress1 = streetAddress1;
    }

    public String getGetStreetAddress2() {
        return getStreetAddress2;
    }

    public void setGetStreetAddress2(String getStreetAddress2) {
        this.getStreetAddress2 = getStreetAddress2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public int getCountry() {
        return country;
    }

    public void setCountry(int country) {
        this.country = country;
    }
}
