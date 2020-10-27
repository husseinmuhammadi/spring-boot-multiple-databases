package com.javastudio.tutorial.multidb.model.mongo;

import javax.persistence.*;

@Entity
@Table(name = "product_specification")
public class ProductSpecification {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
