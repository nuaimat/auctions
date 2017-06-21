package edu.mum.cs544.auctions.domain;

import javax.persistence.*;
import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;

/**
 * Created by Subhechha Bista on 6/21/2017.
 */
@Entity
@Transactional(value = Transactional.TxType.MANDATORY)
public class Bid {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @NotNull
    User customer;

    @OneToOne
    @NotNull
    Auction auction;

    double amount;

    public Bid() {}

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public User getCustomer() { return customer; }

    public void setCustomer(User customer) {this.customer = customer; }

    public Auction getAuction() { return auction; }

    public void setAuction(Auction auction) { this.auction = auction; }

    public double getAmount() { return amount; }

    public void setAmount(double amount) { this.amount = amount; }
}
