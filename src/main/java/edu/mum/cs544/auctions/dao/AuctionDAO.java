package edu.mum.cs544.auctions.dao;

import edu.mum.cs544.auctions.domain.Auction;
import edu.mum.cs544.auctions.domain.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Mo Nuaimat <nuaimat@gmail.com>
 * nuaimat on 6/19/17.
 */
public interface AuctionDAO extends PagingAndSortingRepository<Auction, Integer> {
    Page<Auction> findByIsActiveOrderByCreatedDesc(boolean active, Pageable p);
    List<Auction> findBySellerIdAndIsDeletedOrderByCreatedDesc(int id, boolean isDeleted);
    List<Auction> findByWinnerId(int id);


    @Query(value = "SELECT DISTINCT a.* FROM auction a JOIN bid b ON a.id=b.auction_id\n" +
            "WHERE b.customer_id=?1 AND a.isActive AND a.end > now()\n" +
            "ORDER BY a.end - now()  ASC" +
            "\n", nativeQuery = true)
    List<Auction> findByAllAuctionsWithMyBids(int id);

    List<Auction> findByIsActiveAndEndLessThan(boolean active, Date d);

}
