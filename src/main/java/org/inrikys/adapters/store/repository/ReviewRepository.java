package org.inrikys.adapters.store.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Parameters;
import jakarta.enterprise.context.ApplicationScoped;
import org.inrikys.adapters.store.entities.ReviewEntity;
import org.inrikys.adapters.store.entities.UserEntity;

import java.util.Optional;

@ApplicationScoped
public class ReviewRepository implements PanacheRepository<ReviewEntity> {

    public boolean existsByUserIdAndProductId(Long userId, Long productId) {
        return count(
                "user.id = :userId and product.id = :productId",
                Parameters.with("userId", userId)
                        .and("productId", productId)
        ) > 0;
    }

}
