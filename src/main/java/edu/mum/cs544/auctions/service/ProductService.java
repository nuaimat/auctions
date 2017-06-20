package edu.mum.cs544.auctions.service;

import edu.mum.cs544.auctions.dao.ItemDAO;
import edu.mum.cs544.auctions.dao.ProductDAO;
import edu.mum.cs544.auctions.domain.Item;
import edu.mum.cs544.auctions.domain.Product;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Mo Nuaimat <nuaimat@gmail.com>
 * nuaimat on 6/19/17.
 */
@Service
@Transactional(value = Transactional.TxType.REQUIRES_NEW)
public class ProductService implements IProductService {
    @Resource
    private ProductDAO productDAO;

    @Resource
    private ItemDAO itemDAO;


    @Override
    public Product getProduct(int pid) {
        return productDAO.findOne(pid);
    }

    @Override
    public Product saveProduct(Product p) {
        return this.productDAO.save(p);
    }

    @Override
    public Item getItem(int i) {
        return this.itemDAO.findOne(i);
    }

    @Override
    public Item saveItem(Item i) {
        return this.itemDAO.save(i);
    }

    @Override
    public List<Item> getItemsByUserName(String user1) {
        return this.itemDAO.findBySeller_UsernameLike(user1);
    }
}
