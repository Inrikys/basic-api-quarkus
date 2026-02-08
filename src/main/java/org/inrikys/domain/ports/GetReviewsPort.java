package org.inrikys.domain.ports;

public interface GetReviewsPort {

    Boolean existsByUserIdAndProductId(Long userId, Long productId);

}
