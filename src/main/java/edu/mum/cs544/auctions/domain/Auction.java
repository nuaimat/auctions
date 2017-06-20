package edu.mum.cs544.auctions.domain;

import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

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

    @OneToOne
    @NotNull
    Item item;

    @OneToOne
    @NotNull
    Seller seller;

    @OneToOne
    Customer winner;

    @Temporal(TemporalType.TIMESTAMP)
    @Past
    private Date start;

    @Temporal(TemporalType.TIMESTAMP)
    private Date end;

    boolean isActive;
    boolean isDeleted;

    private double minimumBid;

    public Auction() {
        this.end = new Date();
    }

    public Auction(Item item, Date start, Date end,
                   boolean isActive, boolean isDeleted, double minimumBid,
                   Seller seller, Customer customer
                   ) {
        this.item = item;
        this.start = start;
        this.end = end;
        this.isActive = isActive;
        this.isDeleted = isDeleted;
        this.minimumBid = minimumBid;
        this.seller = seller;
        this.winner = customer;
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

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public Customer getWinner() {
        return winner;
    }

    public void setWinner(Customer winner) {
        this.winner = winner;
    }
}
