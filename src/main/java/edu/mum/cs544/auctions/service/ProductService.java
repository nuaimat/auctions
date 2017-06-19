package edu.mum.cs544.auctions.service;

import edu.mum.cs544.auctions.dao.ItemDAO;
import edu.mum.cs544.auctions.dao.ProductDAO;
import edu.mum.cs544.auctions.domain.Item;
import edu.mum.cs544.auctions.domain.Product;
import org.springframework.stereotype.Service;

/**
 * Created by Mo Nuaimat <nuaimat@gmail.com>
 * nuaimat on 6/19/17.
 */
@Service
public class ProductService implements IProductService {
    private ProductDAO productDAO;
    private ItemDAO itemDAO;


    public ProductService(ProductDAO productDAO, ItemDAO itemDAO) {
        this.productDAO = productDAO;
        this.itemDAO = itemDAO;
    }

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
}
