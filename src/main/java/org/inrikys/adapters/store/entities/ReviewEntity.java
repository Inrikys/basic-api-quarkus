package org.inrikys.adapters.store.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.inrikys.domain.enums.ReviewStatus;
import org.inrikys.domain.models.Review;

import java.time.LocalDateTime;

@Entity(name = "review")
@Table(name = "REVIEWS", indexes = {
        @Index(
                name = "idx_review_user_product",
                columnList = "user_id, product_id"
        )
})
public class ReviewEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "product_id", nullable = false)
    private ProductEntity product;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @Column(name = "rating", nullable = false)
    private Integer rating;

    @Column(name = "commentary")
    private String commentary;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private ReviewStatus status;

    @CreationTimestamp
    private LocalDateTime creationDate;

    @UpdateTimestamp
    private LocalDateTime updateDate;

    public ReviewEntity() {
    }

    public ReviewEntity(Long id, ProductEntity product, UserEntity user, Integer rating, String commentary, ReviewStatus status, LocalDateTime creationDate, LocalDateTime updateDate) {
        this.id = id;
        this.product = product;
        this.user = user;
        this.rating = rating;
        this.commentary = commentary;
        this.status = status;
        this.creationDate = creationDate;
        this.updateDate = updateDate;
    }


    public Review toReview() {
        return new Review(id, product.getId(), user.getId(), rating, commentary, status, creationDate, updateDate);
    }

    public Long getId() {
        return id;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public UserEntity getUser() {
        return user;
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
