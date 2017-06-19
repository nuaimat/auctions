package edu.mum.cs544.auctions.service;

import edu.mum.cs544.auctions.dao.UserDAO;
import edu.mum.cs544.auctions.domain.User;

/**
 * Created by Subhechha Bista on 6/19/2017.
 */
public class UserService  implements IUserService{
    private UserDAO userDAO;

    public UserService(UserDAO userDAO){
        this.userDAO = userDAO;
    }


    @Override
    public User getUser(int id) {return userDAO.findOne(id);}

    @Override
    public User saveUser(User user) {return this.userDAO.save(user);}
}
