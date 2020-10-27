package com.javastudio.tutorial.multidb.repository.oracle;

import com.javastudio.tutorial.multidb.model.oracle.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
