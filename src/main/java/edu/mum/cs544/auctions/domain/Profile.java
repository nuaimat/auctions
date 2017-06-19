package edu.mum.cs544.auctions.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Subhechha Bista on 6/19/2017.
 */
@Entity
public class Profile {

    @Id
    @GeneratedValue
    private int id;
    private String fullName;
    private String profileImage;
    @OneToMany
    private List<Address> address = new ArrayList<Address>();
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
}
