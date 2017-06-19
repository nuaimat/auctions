package edu.mum.cs544.auctions.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by Mo Nuaimat <nuaimat@gmail.com>
 * nuaimat on 6/19/17.
 */

@Entity
public class Item {
    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    @NotNull
    private Product product;

    // TODO add when ready
    // private Seller seller;

    private int quantity;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    public Item() {
    }

    public Item(Product product, int quantity, Date created) {
        this.product = product;
        this.quantity = quantity;
        this.created = created;
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
}
