package edu.mum.cs544.auctions.service;

import edu.mum.cs544.auctions.dao.AuctionDAO;
import edu.mum.cs544.auctions.dao.UserDAO;
import edu.mum.cs544.auctions.domain.Auction;
import edu.mum.cs544.auctions.domain.Item;
import edu.mum.cs544.auctions.domain.Product;
import edu.mum.cs544.auctions.domain.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Mo Nuaimat <nuaimat@gmail.com>
 * nuaimat on 6/19/17.
 */
@Service
@Transactional(value = Transactional.TxType.REQUIRES_NEW)
public class AuctionService implements IAuctionService {

    @Resource
    private AuctionDAO auctionDao;

    @Resource
    private UserDAO userDAO;

    @Override
    public Auction getAuction(int aid) {
        return auctionDao.getOne(aid);
    }

    @Override
    public Auction saveAuction(Auction a) {
        User s = userDAO.save(a.getSeller());
        a.setSeller(s);
        a.getItem().setSeller(s);
        return this.auctionDao.save(a);
    }

    @Override
    public List<Auction> getAuctions() {
        return this.auctionDao.findAll();
    }

    @Override
    public List<Auction> getActiveAuctions() {
        boolean active = true;
        return auctionDao.findByIsActiveOrderByCreatedDesc(active);
    }

    @Override
    public Auction getEmptyAuction() {
        Auction auc = new Auction();
        User me = new User(); // TODO fix this
        me.setId(1);


        Item i = new Item();
        Product p = new Product();
        i.setProduct(p);
        auc.setItem(i);
        auc.setSeller(me);

        return auc;
    }


}
