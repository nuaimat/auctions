package edu.mum.cs544.registration;


import edu.mum.cs544.auctions.dao.AuctionDAO;
import edu.mum.cs544.auctions.dao.UserDAO;
import edu.mum.cs544.auctions.domain.*;
import edu.mum.cs544.auctions.service.AuctionService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;
import javax.inject.Inject;
import java.sql.Date;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@ContextConfiguration("file:src/main/webapp/WEB-INF/springconfig.xml")
public class RegistrationControllerTest  {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    Auction temp;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();

        User seller = new User();
        seller.setRole("ROLE_SELLER");
        seller.setUsername("seller");
        seller.setPassword("test");


        Product p = new Product("Test","Test", new java.util.Date(), new java.util.Date(), "");

        Item i = new Item();
        i.setSeller(seller);
        i.setQuantity(2);
        i.setProduct(p);


        temp = new Auction(i,
                Date.from(Instant.now().minusSeconds(36000)),
                Date.from(Instant.now().plusSeconds(36000)),
                true,
                false,
                0.3,
                seller,
                null
        );
        temp.setBids(new ArrayList<>());

        temp = auctionService.saveAuction(temp);
        auctionService.setCurrentMinBid(temp);
    }


    @Test
    public void displaysSignupForm() throws Exception {
        mockMvc.perform(get("/register"))
                .andExpect(model().attributeExists("user"))
                .andExpect(view().name("register"));
    }

    @Inject
    AuctionService auctionService;

    @Resource
    private AuctionDAO auctionDao;

    @Resource
    private UserDAO userDAO;

    @Test
    public void testAuctionServiceGetActive(){

        List<Auction> auctionsList = auctionService.getActiveAuctions();
        Assert.assertTrue(auctionsList.size() > 0);

    }

    @Test
    public void auctionServicePersistAuction(){
        List<Auction> auctionsList = auctionService.getActiveAuctions();
        Assert.assertTrue("Could not find temp Auction " + temp, auctionsList.contains(temp));
    }

    @Test
    public void testAuctionServiceStatusLogic(){
        Assert.assertEquals(temp.getStatusAsString(), "Running");
    }

    @Test
    public void testAuctionServiceCurrentMinimumBidLogic(){
        Assert.assertEquals(temp.getCurrentMinBid(), temp.getMinimumBid(), 0.01);
    }

    @After
    public void cleanup(){
        auctionDao.delete(temp);
        userDAO.delete(temp.getSeller());
    }
}
