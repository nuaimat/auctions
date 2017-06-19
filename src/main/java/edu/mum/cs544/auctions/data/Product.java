package edu.mum.cs544.auctions.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Mo Nuaimat <nuaimat@gmail.com>
 * nuaimat on 6/19/17.
 */
@Entity
public class Product {
    
    @Id
    @GeneratedValue
    private int id;

    public Product(){

    }
}
