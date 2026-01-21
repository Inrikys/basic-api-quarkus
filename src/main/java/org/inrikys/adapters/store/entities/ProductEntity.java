package org.inrikys.adapters.store.entities;

import jakarta.persistence.*;
import org.inrikys.domain.models.Product;

@Entity(name = "product")
@Table(name = "PRODUCTS")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    public ProductEntity() {
    }

    public ProductEntity(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public ProductEntity(Product newProduct) {
        this.id = newProduct.getId();
        this.name = newProduct.getName();
        this.description = newProduct.getDescription();
    }

    public Product toProduct() {
        return new Product(id, name, description);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name.toLowerCase();
    }

    public String getDescription() {
        return description;
    }
}
