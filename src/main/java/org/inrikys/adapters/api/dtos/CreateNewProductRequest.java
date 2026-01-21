package org.inrikys.adapters.api.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.inrikys.domain.models.Product;

public record CreateNewProductRequest(
        @JsonProperty("name")
        String name,

        @JsonProperty("description")
        String description
) {
    public Product toProduct() {
        return new Product(null, name, description);
    }
}
