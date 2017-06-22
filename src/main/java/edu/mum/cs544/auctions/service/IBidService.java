package edu.mum.cs544.auctions.service;

import edu.mum.cs544.auctions.domain.Bid;

/**
 * Created by Subhechha Bista on 6/21/2017.
 */
public interface IBidService {
    Bid saveBid(Bid b);

    int getTotalBidsCount();
}
