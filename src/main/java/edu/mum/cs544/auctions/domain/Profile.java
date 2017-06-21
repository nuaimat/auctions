package edu.mum.cs544.auctions.domain;

import javax.persistence.*;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Subhechha Bista on 6/19/2017.
 */
@Entity
@Transactional(value = Transactional.TxType.MANDATORY)
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String profileImage;

    @OneToMany(cascade = CascadeType.ALL)
    @NotNull
    private List<Address> address = new ArrayList<Address>();

    @OneToOne
    @Valid
    private User user;


    public Profile() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
