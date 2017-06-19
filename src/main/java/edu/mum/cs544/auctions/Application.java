package edu.mum.cs544.auctions;

import edu.mum.cs544.auctions.domain.Auction;
import edu.mum.cs544.auctions.domain.Item;
import edu.mum.cs544.auctions.domain.Product;
import edu.mum.cs544.auctions.domain.Seller;
import edu.mum.cs544.auctions.service.IAuctionService;
import edu.mum.cs544.auctions.service.IProductService;
import edu.mum.cs544.auctions.service.IUserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * Created by Mo Nuaimat <nuaimat@gmail.com>
 * nuaimat on 6/19/17.
 */
public class Application {
    public static void main(String[] args) {
        System.out.println("Hello! World");

        ApplicationContext context = new ClassPathXmlApplicationContext("springconfig.xml");
        IProductService productService = context.getBean("productService", IProductService.class);

        Product p = new Product("Test Prod",
                "Test Desc",
                Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()),
                Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()),
                "test.jpg"
                );

        p = productService.saveProduct(p);
        System.out.println(p);
        Seller s = new Seller();
        s.setId(1);
        s.setStars(0);
        s.setUsername("seller1");
        s.setPassword("seller1");
        s.setRole("SELLER");

        IUserService userService = context.getBean("userService", IUserService.class);
        s = userService.saveSeller(s);

        System.out.println("s: " + s);

        Item i = new Item(
                p,
                s,
                33,
                Date.from(LocalDateTime.now()
                        .atZone(ZoneId.systemDefault())
                        .toInstant()));
        i = productService.saveItem(i);

        System.out.println(i);

        Auction auction = new Auction(
                i,
                Date.from(LocalDateTime.now()
                        .atZone(ZoneId.systemDefault())
                        .toInstant()),
                null,
                true,
                false,
                3.44,
                s,
                null
        );


        IAuctionService auctionService = context.getBean("auctionService", IAuctionService.class);
        auctionService.saveAuction(auction);


    }
}
