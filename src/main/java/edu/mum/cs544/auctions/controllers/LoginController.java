package edu.mum.cs544.auctions.controllers;

import edu.mum.cs544.auctions.dao.UserDAO;
import edu.mum.cs544.auctions.domain.User;
import edu.mum.cs544.auctions.service.IUserService;
import edu.mum.cs544.auctions.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Subhechha Bista on 6/20/2017.
 */
@Controller
public class LoginController {
    @Resource
    IUserService userService;


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("login");
        mav.addObject("login", new User());
        return mav;
    }


}
