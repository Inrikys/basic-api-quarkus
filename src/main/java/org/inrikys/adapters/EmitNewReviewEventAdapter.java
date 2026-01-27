package org.inrikys.adapters;

import jakarta.enterprise.context.ApplicationScoped;
import org.inrikys.adapters.message.kafka.out.ReviewProducer;
import org.inrikys.domain.models.Review;
import org.inrikys.domain.ports.EmitNewReviewEventPort;
import org.jboss.logging.Logger;

@ApplicationScoped
public class EmitNewReviewEventAdapter implements EmitNewReviewEventPort {

    private static final Logger LOG = Logger.getLogger(EmitNewReviewEventAdapter.class);
    private final ReviewProducer reviewProducer;

    public EmitNewReviewEventAdapter(ReviewProducer reviewProducer) {
        this.reviewProducer = reviewProducer;
    }

    @Override
    public void emit(Review review) {
        LOG.info("Emitting event New Review");
        reviewProducer.getReviewEmitter().send(review.toString());
    }
}
