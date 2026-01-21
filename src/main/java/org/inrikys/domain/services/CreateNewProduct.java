package org.inrikys.domain.services;

import org.inrikys.domain.models.Product;
import org.inrikys.domain.ports.CreateNewProductPort;

public class CreateNewProduct {

    private final CreateNewProductPort createNewProductPort;

    public CreateNewProduct(CreateNewProductPort createNewProductPort) {
        this.createNewProductPort = createNewProductPort;
    }

    public Product create(Product product) {
        return createNewProductPort.saveNewProduct(product);
    }
}
