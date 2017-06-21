package edu.mum.cs544.auctions.service;

import edu.mum.cs544.auctions.dao.AuctionDAO;
import edu.mum.cs544.auctions.dao.UserDAO;
import edu.mum.cs544.auctions.domain.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.persistence.Transient;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mo Nuaimat <nuaimat@gmail.com>
 * nuaimat on 6/19/17.
 */
@Service
@Transactional(value = Transactional.TxType.REQUIRES_NEW)
public class AuctionService implements IAuctionService {

    @Transient
    private int PAGE_SIZE = 2;

    @Resource
    private AuctionDAO auctionDao;

    @Resource
    private UserDAO userDAO;

    @Override
    public Auction getAuction(int aid) {
        return auctionDao.findOne(aid);
    }

    @Override
    public Auction saveAuction(Auction a) {
        User s = userDAO.save(a.getSeller());
        a.setSeller(s);
        a.getItem().setSeller(s);
        return this.auctionDao.save(a);
    }

    /*@Override
    public List<Auction> getAuctions() {
        return this.auctionDao.findAll();
    }*/

    @Override
    public List<Auction> getActiveAuctions() {
        boolean active = true;
        PageRequest page = new PageRequest(0, PAGE_SIZE);
        return auctionDao.findByIsActiveOrderByCreatedDesc(active, page).getContent();
    }

    @Override
    public List<Auction> getAuctionsBySellerId(User seller) {
        return auctionDao.findBySellerIdAndIsDeletedOrderByCreatedDesc(seller.getId(), false);
    }

    @Override
    public List<Auction> getMyBiddingsAuctions(User customer) {
        // TODO needs impl fetch list of auctions that customer has 1. won OR 2. bidded on and still active
        return auctionDao.findBySellerIdAndIsDeletedOrderByCreatedDesc(customer.getId(), false);
    }

    @Override
    public Auction getEmptyAuction() {
        Auction auc = new Auction();
        User me = new User();
        me.setId(1);


        Item i = new Item();
        Product p = new Product();
        i.setProduct(p);
        auc.setItem(i);
        auc.setSeller(me);

        return auc;
    }

    @Override
    public Page<Auction> getActiveAuctionsPage(Integer pageIndex) {
        boolean active = true;
        PageRequest page = new PageRequest(pageIndex, 1);
        return auctionDao.findByIsActiveOrderByCreatedDesc(active, page);
    }

}
