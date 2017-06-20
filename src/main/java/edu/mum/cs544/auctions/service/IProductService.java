package edu.mum.cs544.auctions.service;

import edu.mum.cs544.auctions.domain.Item;
import edu.mum.cs544.auctions.domain.Product;

import java.util.List;

/**
 * Created by Mo Nuaimat <nuaimat@gmail.com>
 * nuaimat on 6/19/17.
 */
public interface IProductService {
    Product getProduct(int pid);
    Product saveProduct(Product p);

    Item getItem(int i);
    Item saveItem(Item i);

    List<Item> getItemsByUserName(String user1);
}
