package org.inrikys.adapters;

import jakarta.enterprise.context.ApplicationScoped;
import org.inrikys.adapters.store.repository.ReviewRepository;
import org.inrikys.domain.ports.GetReviewsPort;

@ApplicationScoped
public class GetReviewsAdapter implements GetReviewsPort {

    private final ReviewRepository reviewRepository;

    public GetReviewsAdapter(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public Boolean existsByUserIdAndProductId(Long userId, Long productId) {
        return reviewRepository.existsByUserIdAndProductId(userId, productId);
    }
}
