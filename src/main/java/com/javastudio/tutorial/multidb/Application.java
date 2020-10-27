package com.javastudio.tutorial.multidb;

import com.javastudio.tutorial.multidb.model.mongo.ProductSpecification;
import com.javastudio.tutorial.multidb.model.oracle.Product;
import com.javastudio.tutorial.multidb.repository.mongo.ProductSpecificationRepository;
import com.javastudio.tutorial.multidb.repository.oracle.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductSpecificationRepository productSpecificationRepository;

    @Bean
    CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            Product product = new Product();
            product.setName("Pencil");
            productRepository.save(product);

            ProductSpecification productSpecification = new ProductSpecification();
            productSpecification.setName("Pencil specifications");
            productSpecificationRepository.save(productSpecification);
        };
    }
}
