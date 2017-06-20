package edu.mum.cs544.auctions.service;

import edu.mum.cs544.auctions.dao.CustomerDAO;
import edu.mum.cs544.auctions.dao.SellerDAO;
import edu.mum.cs544.auctions.dao.UserDAO;
import edu.mum.cs544.auctions.domain.Customer;
import edu.mum.cs544.auctions.domain.Seller;
import edu.mum.cs544.auctions.domain.User;

/**
 * Created by Subhechha Bista on 6/19/2017.
 */
public class UserService implements IUserService {
    private CustomerDAO customerDAO;
    private SellerDAO sellerDAO;

    public UserService(SellerDAO sellerDAO, CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
        this.sellerDAO = sellerDAO;
    }


    @Override
    public Seller getSeller(int id) {
        return sellerDAO.findOne(id);

    }

    @Override
    public Seller saveSeller(Seller seller) {
        return this.sellerDAO.save(seller);
    }

    @Override
    public Customer getCustomer(int id) {
        return customerDAO.findOne(id);
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return this.customerDAO.save(customer);
    }
}
