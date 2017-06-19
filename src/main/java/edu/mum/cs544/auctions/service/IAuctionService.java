package edu.mum.cs544.auctions.service;

import edu.mum.cs544.auctions.domain.Auction;

/**
 * Created by Mo Nuaimat <nuaimat@gmail.com>
 * nuaimat on 6/19/17.
 */
public interface IAuctionService {
    Auction getAuction(int aid);
    Auction saveAuction(Auction a);
}
