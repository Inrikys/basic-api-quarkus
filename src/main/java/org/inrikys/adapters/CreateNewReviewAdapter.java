package org.inrikys.adapters;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.inrikys.adapters.store.entities.ProductEntity;
import org.inrikys.adapters.store.entities.ReviewEntity;
import org.inrikys.adapters.store.entities.UserEntity;
import org.inrikys.adapters.store.repository.ProductRepository;
import org.inrikys.adapters.store.repository.ReviewRepository;
import org.inrikys.adapters.store.repository.UserRepository;
import org.inrikys.domain.models.Review;
import org.inrikys.domain.ports.CreateNewReviewPort;
import org.jboss.logging.Logger;

import java.util.Optional;

@ApplicationScoped
public class CreateNewReviewAdapter implements CreateNewReviewPort {

    private static final Logger LOG = Logger.getLogger(CreateNewReviewAdapter.class);

    private final ReviewRepository reviewRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    public CreateNewReviewAdapter(ReviewRepository reviewRepository, ProductRepository productRepository, UserRepository userRepository) {
        this.reviewRepository = reviewRepository;
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public Review createNewReview(Review review) {

        LOG.info("Creating a new review");
        Optional<UserEntity> possibleUser = userRepository.findByIdOptional(review.getUserId());

        if (possibleUser.isEmpty()) {
            LOG.error("User not found: " + review.getUserId());
            throw new IllegalArgumentException("User not found");
        }

        Optional<ProductEntity> possibleProduct = productRepository.findByIdOptional(review.getProductId());

        if (possibleProduct.isEmpty()) {
            LOG.error("Product not found: " + review.getProductId());
            throw new IllegalArgumentException("Product not found");
        }

        ReviewEntity reviewEntity = review.toReviewEntity(possibleProduct.get(), possibleUser.get());
        reviewRepository.persist(reviewEntity);

        return reviewEntity.toReview();
    }
}
