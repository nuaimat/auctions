package edu.mum.cs544.auctions.controllers;

import edu.mum.cs544.auctions.domain.*;
import edu.mum.cs544.auctions.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

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
    private IUserService userService;

    @Resource
    private IBidService bidService;

    @Resource
    private IFileUploadService fileUploadService;

    @Autowired
    private Validator validator;


    @RequestMapping(value = {"/auctions", "/"}, method = RequestMethod.GET)
    public String getAll(Model model) {
        List<Auction> auctionsList = auctionService.getActiveAuctions();
        for(Auction a:auctionsList){
            auctionService.setCurrentMinBid(a);
        }
        model.addAttribute("auctions", auctionsList);
		
        model.addAttribute("auction", new Auction());
		model.addAttribute("bid",new Bid());
		model.addAttribute("total_auctions_count", auctionService.getTotalAuctionsCount());
        model.addAttribute("active_auctions_count", auctionsList.size());
        model.addAttribute("total_bid_count", bidService.getTotalBidsCount());


        return "auctions/auctionList";
    }


    @RequestMapping(value = "/auctions/{id}", method = RequestMethod.GET)
    public String get(Model model, @PathVariable("id") int id) {
        List<Auction> auctionsList = new ArrayList<>();
        auctionsList.add(auctionService.getAuction(id));
        for(Auction a:auctionsList){
            auctionService.setCurrentMinBid(a);
        }
        model.addAttribute("auctions", auctionsList);

        model.addAttribute("auction", new Auction());
        model.addAttribute("bid",new Bid());
        return "auctions/oneAuctionWithBorders";
    }



    @Secured("ROLE_CUSTOMER")
    @RequestMapping(value = "/auctions/my", method = RequestMethod.GET)
    public String myBiddings(Model model, @RequestParam(required = false) String wins) {
        boolean w=true;
        if(wins==null){
            w=false;
        }
        User me = userService.getCurrentUser();
        List<Auction> auctionsList = auctionService.getMyBiddingsAuctions(me, w);
        for(Auction a:auctionsList){
            auctionService.setCurrentMinBid(a);
        }
        model.addAttribute("auctions", auctionsList);

        model.addAttribute("auction", new Auction());
        model.addAttribute("bid",new Bid());
        model.addAttribute("wins", w);
        return "auctions/myBids";
    }

    @Secured("ROLE_SELLER")
    @RequestMapping(value = "/auctions/add", method = RequestMethod.GET)
    public String showAddAuction(Model model){
        model.addAttribute("auction", auctionService.getEmptyAuction());
        return "auctions/addAuction";
    }

    @Secured("ROLE_SELLER")
    @RequestMapping(value = "/auctions", method = RequestMethod.POST)
    public String save(@ModelAttribute Auction auction,
                       @RequestParam("product_image") MultipartFile product_image,
                       final BindingResult br) throws IOException {

        User me = userService.getCurrentUser();
        auction.setSeller(me);

        validator.validate(auction, br);

        if(br.hasErrors()){
            return "auctions/addAuction";
        }

        if(!product_image.isEmpty()){
            String prodFileName  = fileUploadService.upload(product_image, "product_" + UUID.randomUUID());
            auction.getItem().getProduct().setImg(prodFileName);
        }


        /*Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName(); */

        auctionService.saveAuction(auction);
        return "redirect:/auctions";
    }

    @Secured("ROLE_SELLER")
    @GetMapping(value = "/auctions/sellerList")
    public String showSellerAuctionList(Model model){
        List<Auction> list = auctionService.getAuctionsBySellerId(userService.getCurrentUser());
        for(Auction a:list){
            auctionService.setCurrentMinBid(a);

        }

        model.addAttribute("myAuctions", list);
        return "auctions/sellerAuctionList";
    }

    @Secured("ROLE_SELLER")
    @PostMapping(value = "/auctions/{id}/activate")
    public String activate(@PathVariable("id") int id) throws IllegalAccessException {
        Auction a = auctionService.getAuction(id);
        User me = userService.getCurrentUser();

        if(a.getSeller().getId() == me.getId()){
            a.setActive(true);
            auctionService.saveAuction(a);
        } else {
            throw new IllegalAccessException("Can't modify auction " + id);
        }

        return "redirect:/auctions/sellerList";
    }


    @Secured("ROLE_SELLER")
    @GetMapping(value = "/auctions/{id}/edit")
    public String editAuction(@PathVariable("id") int id, Model model) throws IllegalAccessException {
        Auction auc = auctionService.getAuction(id);
        User me = userService.getCurrentUser();
        if(auc.getSeller().getId() == me.getId()){
            model.addAttribute("auction", auc);
            return "auctions/addAuction";
        } else {
            throw new IllegalAccessException("Can't modify auction " + id);
        }

    }

    @Secured("ROLE_SELLER")
    @PostMapping(value = "/auctions/{id}/delete")
    public String softDelete(@PathVariable("id") int id) throws IllegalAccessException {
        Auction a = auctionService.getAuction(id);
        User me = userService.getCurrentUser();

        if(a.getSeller().getId() == me.getId()){
            a.setDeleted(true);
            a.setActive(false);
            auctionService.saveAuction(a);
        } else {
            throw new IllegalAccessException("Can't delete auction " + id);
        }

        return "redirect:/auctions/sellerList";
    }
    @Secured("ROLE_CUSTOMER")
    @RequestMapping(value = "/auctions/bid", method = RequestMethod.POST)
    public String saveBid (@ModelAttribute Bid bid, BindingResult br, @RequestParam int auction_id) {
        Auction a = auctionService.getAuction(auction_id);
        auctionService.setCurrentMinBid(a);
        User me = userService.getCurrentUser();
        if(bid.getAmount() > a.getCurrentMinBid()){
            bid.setCustomer(me);
            bid.setAuction(a);
            validator.validate(bid, br);
            if(br.hasErrors()){
                return "/auctions/auctionList";
            }
           bidService.saveBid(bid);
            return "redirect:/auctions";

        } else {
            throw new IllegalArgumentException("Bid should be greater than " + a.getCurrentMinBid());
        }


    }
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }




}
