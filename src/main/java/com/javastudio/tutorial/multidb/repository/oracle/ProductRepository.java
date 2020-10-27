package com.javastudio.tutorial.multidb.repository;

import com.javastudio.tutorial.multidb.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
