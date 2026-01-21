package org.inrikys.adapters.store.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.inrikys.adapters.store.entities.ProductEntity;
import org.inrikys.adapters.store.entities.UserEntity;

import java.util.Optional;

@ApplicationScoped
public class ProductRepository implements PanacheRepository<ProductEntity> {

    public Optional<ProductEntity> findByName(String name) {
        return find("name", name).firstResultOptional();
    }

}
