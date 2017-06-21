package edu.mum.cs544.auctions.service;


import edu.mum.cs544.auctions.domain.User;

/**
 * Created by Subhechha Bista on 6/19/2017.
 */
public interface IUserService {

    User getUser(int id);
    User saveUser(User user);
    User getCurrentUser();
    User getUserByUserName(String username);

}
