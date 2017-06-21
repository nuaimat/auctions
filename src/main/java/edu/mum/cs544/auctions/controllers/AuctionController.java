package edu.mum.cs544.auctions.controllers;

import edu.mum.cs544.auctions.domain.Auction;
import edu.mum.cs544.auctions.domain.Item;
import edu.mum.cs544.auctions.domain.Product;
import edu.mum.cs544.auctions.domain.User;
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
import javax.validation.Valid;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    private IProductService productsService;

    @Resource
    private IUserService userService;

    @Resource
    private IFileUploadService fileUploadService;

    @Autowired
    Validator validator;

    /* file upload */



    /*@RequestMapping("/")
    public String redirectRoot() {
        return "redirect:/auctions";
    }*/

    @RequestMapping(value = {"/auctions", "/"}, method = RequestMethod.GET)
    public String getAll(Model model) {
        model.addAttribute("auctions", auctionService.getActiveAuctions());
        model.addAttribute("auction", new Auction());
        return "auctions/auctionList";
    }
    @Secured("ROLE_SELLER")
    @RequestMapping(value = "/auctions/add", method = RequestMethod.GET)
    public String showAddAuction(Model model){

        /*Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName(); */
        /*Auction auc = auctionService.getAuctions().get(0);
        auc.setId(0);
        auc.getItem().getProduct().setId(0);
        auc.getItem().setId(0);
        */

        model.addAttribute("auction", auctionService.getEmptyAuction());
        model.addAttribute("myItems", productsService.getUnauctionedItemsBySellerUserName("seller1"));
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

        String prodFileName  = fileUploadService.upload(product_image, "product_" + UUID.randomUUID());
        auction.getItem().getProduct().setImg(prodFileName);

        /*Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName(); */

        auctionService.saveAuction(auction);
        return "redirect:/auctions";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }
}
