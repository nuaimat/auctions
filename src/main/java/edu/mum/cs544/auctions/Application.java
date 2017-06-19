package edu.mum.cs544.auctions;

import edu.mum.cs544.auctions.domain.Product;
import edu.mum.cs544.auctions.service.IProductService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Date;
import java.sql.Time;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * Created by Mo Nuaimat <nuaimat@gmail.com>
 * nuaimat on 6/19/17.
 */
public class Application {
    public static void main(String[] args) {
        System.out.println("Hello! World");

        ApplicationContext context = new ClassPathXmlApplicationContext("springconfig.xml");
        IProductService productService = context.getBean("productService", IProductService.class);

        Product p = new Product("Test Prod",
                "Test Desc",
                Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()),
                Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()),
                "test.jpg"
                );

        p = productService.saveProduct(p);
        System.out.println(p);

    }
}
