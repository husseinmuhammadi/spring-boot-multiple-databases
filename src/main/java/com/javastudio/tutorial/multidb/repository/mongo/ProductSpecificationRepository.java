package com.javastudio.tutorial.multidb.repository.mongo;

import com.javastudio.tutorial.multidb.model.mongo.ProductSpecification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductSpecificationRepository extends JpaRepository<ProductSpecification, Long> {
}
