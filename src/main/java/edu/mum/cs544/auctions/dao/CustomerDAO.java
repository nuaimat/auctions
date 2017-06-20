package edu.mum.cs544.auctions.dao;

import edu.mum.cs544.auctions.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Subhechha Bista on 6/19/2017.
 */
public interface CustomerDAO extends JpaRepository<Customer, Integer>{
}
