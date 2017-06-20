package edu.mum.cs544.auctions.service;

import edu.mum.cs544.auctions.dao.UserDAO;
import edu.mum.cs544.auctions.domain.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by Subhechha Bista on 6/19/2017.
 */
@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class UserService implements IUserService {


    @Resource
    private UserDAO userDAO;

    @Override
    public User getUser(int id) {
        return userDAO.findOne(id);
    }

    @Override
    public User saveUser(User user) {
        return this.userDAO.save(user);
    }



}
