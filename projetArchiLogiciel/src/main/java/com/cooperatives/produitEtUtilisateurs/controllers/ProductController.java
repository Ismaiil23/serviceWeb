package com.cooperatives.produitEtUtilisateurs.controllers;

import com.cooperatives.produitEtUtilisateurs.models.Product;
import com.cooperatives.produitEtUtilisateurs.services.ProductService;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/products")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductController {

    @Inject
    private ProductService productService;

    @POST
    public Product createProduct(Product product) {
        return productService.createProduct(product);
    }

    @GET
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @GET
    @Path("/{id}")
    public Product getProductById(@PathParam("id") Long id) {
        return productService.getProductById(id);
    }

    @PUT
    @Path("/{id}")
    public Product updateProduct(@PathParam("id") Long id, Product product) {
        return productService.updateProduct(id, product);
    }

    @DELETE
    @Path("/{id}")
    public Response deleteProduct(@PathParam("id") Long id) {
        if (productService.deleteProduct(id)) {
            return Response.status(Response.Status.NO_CONTENT).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}

