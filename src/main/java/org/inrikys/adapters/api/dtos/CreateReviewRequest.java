package org.inrikys.adapters.api.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.inrikys.domain.models.Review;

public record CreateReviewRequest(

        @NotNull(message = "userId é obrigatório")
        @JsonProperty("userId")
        Long userId,

        @NotNull(message = "rating é obrigatório")
        @Min(value = 1, message = "rating deve ser no mínimo 1")
        @Max(value = 5, message = "rating deve ser no máximo 5")
        @JsonProperty("rating")
        Integer rating,

        @JsonProperty("commentary")
        String commentary
) {

    public Review toReview(Long productId) {
        return new Review(null, productId, userId, rating, commentary);
    }

}
