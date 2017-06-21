package edu.mum.cs544.auctions.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Subhechha Bista on 6/19/2017.
 */
@Entity
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String fullName;
    private String profileImage;
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Address> address = new ArrayList<Address>();
    @OneToOne
    private User user;


    public Profile() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public List<Address> getAddress() { return address; }

    public void setAddress(List<Address> address) { this.address = address; }

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }
}
