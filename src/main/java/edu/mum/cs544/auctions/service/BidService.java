package edu.mum.cs544.auctions.service;

import edu.mum.cs544.auctions.dao.BidDAO;
import edu.mum.cs544.auctions.domain.Bid;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

/**
 * Created by Subhechha Bista on 6/21/2017.
 */
@Service
@Transactional(value = Transactional.TxType.REQUIRES_NEW)
public class BidService implements IBidService {
    @Resource
    private BidDAO bidDAO;

    @Override
    public Bid saveBid(Bid b) {
        return this.bidDAO.save(b);
    }
}
