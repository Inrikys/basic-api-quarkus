package org.inrikys.domain.ports;

import org.inrikys.domain.models.Product;

public interface CreateNewProductPort {

    Product saveNewProduct(Product newProduct);

}
