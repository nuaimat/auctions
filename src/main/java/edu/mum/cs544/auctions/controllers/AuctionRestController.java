package edu.mum.cs544.auctions.controllers;

import edu.mum.cs544.auctions.domain.Auction;
import edu.mum.cs544.auctions.domain.Bid;
import edu.mum.cs544.auctions.service.IAuctionService;
import edu.mum.cs544.auctions.service.IUserService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Mo Nuaimat <nuaimat@gmail.com>
 * nuaimat on 6/21/17.
 */
@RestController
public class AuctionRestController {
    @Resource
    private IAuctionService auctionService;

    @Resource
    private IUserService userService;

    @GetMapping(value = "/json/auctions", produces = "application/json")
    public List<Auction> getAuctions(@RequestParam(value = "page", required = false) Integer page) {
        if(page == null){
            page = 0;
        }

        return auctionService.getActiveAuctionsPage(page).getContent();

    }

    @GetMapping( value = "/json/auctions/{id}" , produces = "application/json")
    public ResponseEntity getAuction(@PathVariable("id") int id) {

        Auction a = auctionService.getAuction(id);
        if (a == null) {
            return new ResponseEntity("No Auction found for ID " + id, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(a, HttpStatus.OK);
    }

    @GetMapping(value = "/api/auctions", produces = "text/html")
    public ModelAndView getAuctionsHtml(@RequestParam(value = "page", required = false) Integer page) {
        ModelAndView mav = new ModelAndView("auctions/aucListPanel");
        if(page == null){
            page = 0;
        }
        Page<Auction> p = auctionService.getActiveAuctionsPage(page);
        List<Auction> auctionsList = p.getContent();

        for(Auction a:auctionsList){
            auctionService.setCurrentMinBid(a);
        }

        mav.addObject("auctions", auctionsList);
        mav.addObject("auction", new Auction());
        mav.addObject("bid",new Bid());

        return mav;
    }
}
