package org.inrikys.domain.models;

import org.inrikys.adapters.store.entities.ProductEntity;
import org.inrikys.adapters.store.entities.ReviewEntity;
import org.inrikys.adapters.store.entities.UserEntity;
import org.inrikys.domain.enums.ReviewStatus;

import java.time.LocalDateTime;

public class Review {

    private Long id;
    private Long productId;
    private Long userId;
    private Integer rating;
    private String commentary;
    private ReviewStatus status;
    private LocalDateTime creationDate;
    private LocalDateTime updateDate;

    public Review(Long id, Long productId, Long userId, Integer rating, String commentary) {

        validateRating(rating);

        this.id = id;
        this.productId = productId;
        this.userId = userId;
        this.rating = rating;
        this.commentary = commentary;
    }

    public Review(Long id, Long productId, Long userId, Integer rating, String commentary, ReviewStatus status, LocalDateTime creationDate, LocalDateTime updateDate) {

        validateRating(rating);

        this.id = id;
        this.productId = productId;
        this.userId = userId;
        this.rating = rating;
        this.commentary = commentary;
        this.status = status;
        this.creationDate = creationDate;
        this.updateDate = updateDate;
    }

    public ReviewEntity toReviewEntity(ProductEntity product, UserEntity user) {
        return new ReviewEntity(id, product, user, rating, commentary, ReviewStatus.APPROVED, creationDate, updateDate);
    }

    // Mantendo regra de validação dentro do domínio também
    void validateRating(Integer rating) {

        if (rating == null) {
            throw new IllegalArgumentException("Rating deve estar entre 1 e 5");
        }

        if (rating < 1 || rating > 5) {
            throw new IllegalArgumentException("Rating deve estar entre 1 e 5");
        }
    }


    public Long getId() {
        return id;
    }

    public Long getProductId() {
        return productId;
    }

    public Long getUserId() {
        return userId;
    }

    public Integer getRating() {
        return rating;
    }

    public String getCommentary() {
        return commentary;
    }

    public ReviewStatus getStatus() {
        return status;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }


}
