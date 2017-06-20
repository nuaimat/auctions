package edu.mum.cs544.auctions.dao;

import edu.mum.cs544.auctions.domain.Auction;
import edu.mum.cs544.auctions.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Mo Nuaimat <nuaimat@gmail.com>
 * nuaimat on 6/19/17.
 */
public interface AuctionDAO extends JpaRepository<Auction, Integer> {
    List<Auction> findByIsActiveOrderByCreatedDesc(boolean active);
}
