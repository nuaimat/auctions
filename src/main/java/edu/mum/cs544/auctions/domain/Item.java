package edu.mum.cs544.auctions.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by Mo Nuaimat <nuaimat@gmail.com>
 * nuaimat on 6/19/17.
 */

@Entity
@Transactional(value = Transactional.TxType.MANDATORY)
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)
    @NotNull
    @Valid
    private Product product;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @NotNull
    private User seller;

    @OneToOne(mappedBy = "item")
    @JsonIgnore
    private Auction auction;

    private int quantity;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created;


    @PrePersist
    @PreUpdate
    protected void onCreate() {
        if (created == null) { created = new Date(); }
    }

    public Item() {
    }

    public Item(Product product, User seller, int quantity, Date created) {
        this.product = product;
        this.quantity = quantity;
        this.created = created;
        this.seller = seller;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", product=" + product.getId() + " : " + product.getName() +
                ", quantity=" + quantity +
                ", created=" + created +
                '}';
    }

    public User getSeller() {
        return seller;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }
}
