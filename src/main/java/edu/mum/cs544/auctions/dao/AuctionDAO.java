package edu.mum.cs544.auctions.dao;

import edu.mum.cs544.auctions.domain.Auction;
import edu.mum.cs544.auctions.domain.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Mo Nuaimat <nuaimat@gmail.com>
 * nuaimat on 6/19/17.
 */
public interface AuctionDAO extends PagingAndSortingRepository<Auction, Integer> {
    Page<Auction> findByIsActiveOrderByCreatedDesc(boolean active, Pageable p);
    List<Auction> findBySellerIdAndIsDeletedOrderByCreatedDesc(int id, boolean isDeleted);

}
