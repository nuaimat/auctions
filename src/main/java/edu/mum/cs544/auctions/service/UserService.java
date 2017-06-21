package edu.mum.cs544.auctions.service;

import edu.mum.cs544.auctions.dao.UserDAO;
import edu.mum.cs544.auctions.domain.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
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

    @Override
    public User getCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        return getUserByUserName(name);
    }

    @Override
    public User getUserByUserName( String name) {
        return userDAO.getByUsername(name);
    }

    @Override
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
