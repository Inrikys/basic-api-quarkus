package org.inrikys.adapters.api.controllers;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.inrikys.domain.services.GetProducts;

@Path("/products")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class GetProductsController {

    private final GetProducts getProducts;

    public GetProductsController(GetProducts getProducts) {
        this.getProducts = getProducts;
    }

    @GET
    public Response getProducts() {
        return Response.ok(getProducts.get()).build();
    }

}
