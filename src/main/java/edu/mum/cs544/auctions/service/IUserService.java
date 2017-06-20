package edu.mum.cs544.auctions.service;


import edu.mum.cs544.auctions.domain.Customer;
import edu.mum.cs544.auctions.domain.Seller;
import edu.mum.cs544.auctions.domain.User;

/**
 * Created by Subhechha Bista on 6/19/2017.
 */
public interface IUserService {


    Seller getSeller(int id);
    Seller saveSeller(Seller seller);

    Customer getCustomer(int id);
    Customer saveCustomer(Customer customer);
}
