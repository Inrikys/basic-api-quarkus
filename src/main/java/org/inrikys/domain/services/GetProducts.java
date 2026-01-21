package org.inrikys.domain.services;

import org.inrikys.domain.models.Product;
import org.inrikys.domain.ports.GetProductsPort;

import java.util.List;

public class GetProducts {

    private final GetProductsPort getProductsPort;

    public GetProducts(GetProductsPort getProductsPort) {
        this.getProductsPort = getProductsPort;
    }

    public List<Product> get() {
        return getProductsPort.getProducts();
    }

}
