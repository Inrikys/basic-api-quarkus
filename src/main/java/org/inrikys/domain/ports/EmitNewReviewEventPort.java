package org.inrikys.domain.ports;

import org.inrikys.domain.models.Review;

public interface EmitNewReviewEventPort {

    void emit(Review review);

}
