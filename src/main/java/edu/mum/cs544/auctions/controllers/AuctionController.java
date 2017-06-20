package edu.mum.cs544.auctions.controllers;

import edu.mum.cs544.auctions.domain.Auction;
import edu.mum.cs544.auctions.service.AuctionService;
import edu.mum.cs544.auctions.service.IAuctionService;
import edu.mum.cs544.auctions.service.IProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServlet;

/**
 * Created by Mo Nuaimat <nuaimat@gmail.com>
 * nuaimat on 6/19/17.
 */

@Controller
public class AuctionController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Resource
    private IAuctionService auctionService;
    @Resource
    private IProductService productsService;

    /*@RequestMapping("/")
    public String redirectRoot() {
        return "redirect:/auctions";
    }*/

    @RequestMapping(value = {"/auctions", "/"}, method = RequestMethod.GET)
    public String getAll(Model model) {
        model.addAttribute("auctions", auctionService.getAuctions());
        model.addAttribute("auction", new Auction());
        return "auctions/auctionList";
    }

    @RequestMapping(value = "/auctions/add", method = RequestMethod.GET)
    public String showAddAuction(Model model){

        /*Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName(); */

        model.addAttribute("auction", auctionService.getAuctions().get(0));
        model.addAttribute("myItems", productsService.getUnauctionedItemsBySellerUserName("seller1"));
        return "auctions/addAuction";
    }
}
