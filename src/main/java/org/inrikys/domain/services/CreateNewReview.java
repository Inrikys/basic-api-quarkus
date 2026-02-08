package org.inrikys.domain.services;

import org.inrikys.domain.models.Review;
import org.inrikys.domain.ports.*;

public class CreateNewReview {

    private final GetUsersPort getUsersPort;
    private final GetProductsPort getProductsPort;
    private final CreateNewReviewPort createNewReviewPort;
    private final EmitNewReviewEventPort emitNewReviewEventPort;
    private final GetReviewsPort getReviewsPort;

    public CreateNewReview(GetUsersPort getUsersPort, GetProductsPort getProductsPort, CreateNewReviewPort createNewReviewPort, EmitNewReviewEventPort emitNewReviewEventPort, GetReviewsPort getReviewsPort) {
        this.getUsersPort = getUsersPort;
        this.getProductsPort = getProductsPort;
        this.createNewReviewPort = createNewReviewPort;
        this.emitNewReviewEventPort = emitNewReviewEventPort;
        this.getReviewsPort = getReviewsPort;
    }

    public Review create(Review review) {

        if (!isValid(review)) {
            throw new IllegalArgumentException("User or Product doesn't exist");
        }

        if (doesUserAlreadyReviewedProduct(review)) {
            throw new IllegalArgumentException("User: " + review.getUserId() + " already reviewed the product: " + review.getProductId());
        }

        Review newReview = createNewReviewPort.createNewReview(review);
        emitNewReviewEventPort.emit(newReview);

        return newReview;
    }

    private boolean isValid(Review review) {
        return getUsersPort.existsById(review.getUserId()) && getProductsPort.existsById(review.getProductId());
    }

    private boolean doesUserAlreadyReviewedProduct(Review review) {
        return getReviewsPort.existsByUserIdAndProductId(review.getUserId(), review.getProductId());
    }

}
