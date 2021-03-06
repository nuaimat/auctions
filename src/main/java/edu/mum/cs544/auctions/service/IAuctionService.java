package edu.mum.cs544.auctions.service;

import edu.mum.cs544.auctions.domain.Auction;
import edu.mum.cs544.auctions.domain.User;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Created by Mo Nuaimat <nuaimat@gmail.com>
 * nuaimat on 6/19/17.
 */
public interface IAuctionService {
    Auction getAuction(int aid);
    Auction saveAuction(Auction a);
    //List<Auction> getAuctions();
    List<Auction> getActiveAuctions();
    List<Auction> getAuctionsBySellerId(User seller);
    List<Auction> getMyBiddingsAuctions(User customer, boolean winsonly);
    Auction getEmptyAuction();

    Page<Auction> getActiveAuctionsPage(Integer page);

    void setCurrentMinBid(Auction a);
    void updateInvalidAuctions();

    int getTotalAuctionsCount();
}
