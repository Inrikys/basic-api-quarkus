package org.inrikys.adapters.message.kafka.out;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

@ApplicationScoped
public class ReviewProducer {

    @Inject
    @Channel("reviews-out")
    Emitter<String> reviewEmitter;

    public Emitter<String> getReviewEmitter() {
        return reviewEmitter;
    }
}
