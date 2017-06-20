package edu.mum.cs544.auctions.domain;

import javax.persistence.*;

/**
 * Created by Subhechha Bista on 6/19/2017.
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;
    private String role;
    private int stars;
    private int winsCount;
    @OneToOne
    private Profile profile;

    public User() {
    }

    public User(String username, String password, String role, int stars, int winsCount) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.stars = stars;
        this.winsCount = winsCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getStars() { return stars; }

    public void setStars(int stars) { this.stars = stars; }

    public int getWinsCount() { return winsCount; }

    public void setWinsCount(int winsCount) { this.winsCount = winsCount;
    }

    public Profile getProfile() { return profile; }

    public void setProfile(Profile profile) { this.profile = profile; }
}
