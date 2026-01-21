package org.inrikys.adapters.api.controllers;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;
import org.inrikys.adapters.api.dtos.CreateNewProductRequest;
import org.inrikys.domain.models.Product;
import org.inrikys.domain.services.CreateNewProduct;

import java.net.URI;

@Path("/products")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CreateProductController {

    private final CreateNewProduct createNewProduct;

    public CreateProductController(CreateNewProduct createNewProduct) {
        this.createNewProduct = createNewProduct;
    }

    @POST
    public Response createNewProduct(CreateNewProductRequest request, @Context UriInfo uriInfo) {

        Product newProduct = request.toProduct();

        Product product = createNewProduct.create(newProduct);

        URI location = uriInfo.getAbsolutePathBuilder()
                .path(String.valueOf(product.getId()))
                .build();

        return Response.created(location).build();
    }

}
