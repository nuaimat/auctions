package edu.mum.cs544.auctions.controllers;

import edu.mum.cs544.auctions.domain.User;
import edu.mum.cs544.auctions.service.IUserService;
import edu.mum.cs544.auctions.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
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
public class RegistrationController {

    @Resource
    public IUserService userService;

    @Autowired
    Validator validator;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("register");
        mav.addObject("user", new User());
        return mav;
    }
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String saveUser (@ModelAttribute User user, final BindingResult br) {

        validator.validate(user, br);

        if(br.hasErrors()){
            return "auctions/register";
        }

        userService.saveUser(user);
        return "redirect:/login";
    }
}
