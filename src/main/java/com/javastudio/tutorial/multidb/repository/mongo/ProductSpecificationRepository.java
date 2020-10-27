package com.javastudio.tutorial.multidb.repository;

import com.javastudio.tutorial.multidb.model.ProductSpecification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductSpecificationRepository extends JpaRepository<ProductSpecification, Long> {
}
