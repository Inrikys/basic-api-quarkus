package org.inrikys.domain.services;

import org.inrikys.domain.models.Review;
import org.inrikys.domain.ports.CreateNewReviewPort;
import org.inrikys.domain.ports.EmitNewReviewEventPort;
import org.inrikys.domain.ports.GetProductsPort;
import org.inrikys.domain.ports.GetUsersPort;

public class CreateNewReview {

    private final GetUsersPort getUsersPort;
    private final GetProductsPort getProductsPort;
    private final CreateNewReviewPort createNewReviewPort;
    private final EmitNewReviewEventPort emitNewReviewEventPort;

    public CreateNewReview(GetUsersPort getUsersPort, GetProductsPort getProductsPort, CreateNewReviewPort createNewReviewPort, EmitNewReviewEventPort emitNewReviewEventPort) {
        this.getUsersPort = getUsersPort;
        this.getProductsPort = getProductsPort;
        this.createNewReviewPort = createNewReviewPort;
        this.emitNewReviewEventPort = emitNewReviewEventPort;
    }

    public Review create(Review review) {

        if (!isValid(review)) {
            throw new IllegalArgumentException("User or Product doesn't exist");
        }

        Review newReview = createNewReviewPort.createNewReview(review);
        emitNewReviewEventPort.emit(newReview);

        return newReview;
    }

    private boolean isValid(Review review) {
        return getUsersPort.existsById(review.getUserId()) && getProductsPort.existsById(review.getProductId());
    }
}
