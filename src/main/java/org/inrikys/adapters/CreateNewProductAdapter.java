package org.inrikys.adapters;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.inrikys.adapters.store.entities.ProductEntity;
import org.inrikys.adapters.store.repository.ProductRepository;
import org.inrikys.domain.models.Product;
import org.inrikys.domain.ports.CreateNewProductPort;
import org.jboss.logging.Logger;

import java.util.Optional;

@ApplicationScoped
public class CreateNewProductAdapter implements CreateNewProductPort {

    private static final Logger LOG = Logger.getLogger(CreateNewProductAdapter.class);
    public final ProductRepository productRepository;

    public CreateNewProductAdapter(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    @Transactional
    public Product saveNewProduct(Product newProduct) {

        Optional<ProductEntity> possibleProduct = productRepository.findByName(newProduct.getName());

        if (possibleProduct.isPresent()) {
            LOG.info("Product with name: " + newProduct.getName() + " already exists");
            // Idempotencia
        }

        ProductEntity productEntity = new ProductEntity(newProduct);
        productRepository.persist(productEntity);

        return productEntity.toProduct();
    }
}
