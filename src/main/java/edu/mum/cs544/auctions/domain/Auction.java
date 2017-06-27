package edu.mum.cs544.auctions.domain;

import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Mo Nuaimat <nuaimat@gmail.com>
 * nuaimat on 6/19/17.
 */
@Entity
@Transactional(value = Transactional.TxType.MANDATORY)
public class Auction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    @NotNull
    @Valid
    Item item;

    @OneToOne(cascade = CascadeType.PERSIST)
    @NotNull
    User seller;

    @OneToOne(cascade = CascadeType.PERSIST)
    User winner;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "auction")
    @OrderBy("amount DESC")
    List<Bid> bids;

    @Temporal(TemporalType.TIMESTAMP)
    @Past
    private Date start;

    @Temporal(TemporalType.TIMESTAMP)
    private Date end;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    @Temporal(TemporalType.TIMESTAMP)
    private Date modified;

    @PrePersist
    @PreUpdate
    protected void onCreate() {
        if (created == null) { created = new Date(); }
        modified = new Date();
    }

    boolean isActive;
    boolean isDeleted;

    private double minimumBid;

    @Transient
    private double currentMinBid;

    @Transient
    private String endTS;

    @Transient
    private String statusAsString;

    public Auction() {
        this.end = new Date();
    }

    public Auction(Item item, Date start, Date end,
                   boolean isActive, boolean isDeleted, double minimumBid,
                   User seller, User winner
                   ) {
        setItem(item);
        this.start = start;
        this.end = end;
        this.isActive = isActive;
        this.isDeleted = isDeleted;
        this.minimumBid = minimumBid;
        this.seller = seller;
        this.winner = winner;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public double getMinimumBid() {
        return minimumBid;
    }

    public void setMinimumBid(double minimumBid) {
        this.minimumBid = minimumBid;
    }

    public User getSeller() {
        return seller;
    }

    public void setSeller(User seller) {
        this.seller = seller;
        this.getItem().setSeller(this.seller);
    }

    public User getWinner() {
        return winner;
    }

    public void setWinner(User winner) {
        this.winner = winner;
    }

    public List<Bid> getBids() { return bids; }

    public void setBids(List<Bid> bids) { this.bids = bids; }

    public double getCurrentMinBid() {
        return currentMinBid;
    }

    public void setCurrentMinBid(double currentMinBid) {
        this.currentMinBid = currentMinBid;
    }

    public String getEndTS() {
        return ""+(getEnd().getTime() / 1000L);
    }

    public String getStatusAsString() {
        statusAsString = "Running";
        if(!isActive()){
            statusAsString = "Inactive";
        }
        if(end.getTime() < new Date().getTime()){
            statusAsString = "Ended";
        }

        return statusAsString;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Auction)) return false;

        Auction auction = (Auction) o;

        if (getId() != auction.getId()) return false;
        if (isActive() != auction.isActive()) return false;
        return isDeleted() == auction.isDeleted();
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + (isActive() ? 1 : 0);
        result = 31 * result + (isDeleted() ? 1 : 0);
        return result;
    }
}
