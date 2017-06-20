package edu.mum.cs544.auctions.dao;

import edu.mum.cs544.auctions.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Mo Nuaimat <nuaimat@gmail.com>
 * nuaimat on 6/19/17.
 */
public interface ItemDAO extends JpaRepository<Item, Integer> {
    List<Item> findBySeller_UsernameLike(String s);
    List<Item> findBySeller_UsernameLikeAndAuctionIsNull(String s);
}
