package org.inrikys.configs;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import org.inrikys.domain.ports.CreateNewProductPort;
import org.inrikys.domain.ports.CreateNewUserPort;
import org.inrikys.domain.ports.GetProductsPort;
import org.inrikys.domain.services.CreateNewProduct;
import org.inrikys.domain.services.CreateNewUser;
import org.inrikys.domain.services.GetProducts;

public class Configuration {

    @Produces
    @ApplicationScoped
    public CreateNewUser createNewUser(CreateNewUserPort createNewUserPort) {
        return new CreateNewUser(createNewUserPort);
    }

    @Produces
    @ApplicationScoped
    public CreateNewProduct createNewProduct(CreateNewProductPort createNewProductPort) {
        return new CreateNewProduct(createNewProductPort);
    }

    @Produces
    @ApplicationScoped
    public GetProducts getProducts(GetProductsPort getProductsPort) {
        return new GetProducts(getProductsPort);
    }

}
