package edu.mum.cs544.auctions.service;

import edu.mum.cs544.auctions.domain.Auction;
import edu.mum.cs544.auctions.domain.User;

import java.util.List;

/**
 * Created by Mo Nuaimat <nuaimat@gmail.com>
 * nuaimat on 6/19/17.
 */
public interface IAuctionService {
    Auction getAuction(int aid);
    Auction saveAuction(Auction a);
    List<Auction> getAuctions();
    List<Auction> getActiveAuctions();
    List<Auction> getAuctionsBySellerId(User seller);
    List<Auction> getMyBiddingsAuctions(User customer);

    Auction getEmptyAuction();
}
