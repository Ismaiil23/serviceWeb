/**

 Cette classe est le contrôleur pour les produits. Elle expose des endpoints REST pour créer, lire, mettre à jour et supprimer des produits.
 */
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
    /**
     * Le service pour la gestion des produits.
     */
    @Inject
    private ProductService productService;

    /**
     * Crée un nouveau produit.
     *
     * @param product Le produit à créer.
     * @return Le produit créé.
     */
    @POST
    public Product createProduct(Product product) {
        return productService.createProduct(product);
    }

    /**
     * Récupère tous les produits.
     *
     * @return La liste des produits.
     */
    @GET
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    /**
     * Récupère un produit par son identifiant.
     *
     * @param id L'identifiant du produit à récupérer.
     * @return Le produit récupéré.
     */
    @GET
    @Path("/{id}")
    public Product getProductById(@PathParam("id") Long id) {
        return productService.getProductById(id);
    }

    /**
     * Met à jour un produit existant.
     *
     * @param id L'identifiant du produit à mettre à jour.
     * @param product Le produit avec les nouvelles informations.
     * @return Le produit mis à jour.
     */
    @PUT
    @Path("/{id}")
    public Product updateProduct(@PathParam("id") Long id, Product product) {
        return productService.updateProduct(id, product);
    }

    /**
     * Supprime un produit existant.
     *
     * @param id L'identifiant du produit à supprimer.
     * @return Une réponse HTTP NO_CONTENT si la suppression a été effectuée avec succès, ou une réponse HTTP NOT_FOUND si le produit n'a pas été trouvé.
     */
    @DELETE
    @Path("/{id}")
    public Response deleteProduct(@PathParam("id") Long id) {
        if (productService.deleteProduct(id)) {
            return Response.status(Response.Status.NO_CONTENT).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

}