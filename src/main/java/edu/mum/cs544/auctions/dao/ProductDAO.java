package edu.mum.cs544.auctions.dao;

import edu.mum.cs544.auctions.domain.Product;
import edu.mum.cs544.auctions.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Mo Nuaimat <nuaimat@gmail.com>
 * nuaimat on 6/19/17.
 */
public interface ProductDAO extends JpaRepository<Product, Integer> {
}
