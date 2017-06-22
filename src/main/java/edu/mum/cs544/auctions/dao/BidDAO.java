package edu.mum.cs544.auctions.dao;

import edu.mum.cs544.auctions.domain.Bid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by Subhechha Bista on 6/21/2017.
 */
public interface BidDAO extends JpaRepository<Bid, Integer> {

}
