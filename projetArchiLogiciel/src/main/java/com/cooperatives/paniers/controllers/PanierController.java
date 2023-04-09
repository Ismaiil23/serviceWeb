package com.cooperatives.paniers.controllers;

import com.cooperatives.paniers.models.Panier;
import com.cooperatives.paniers.services.PanierService;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

/**
 * La classe PanierResource implémente les points d'accès à l'API pour les opérations CRUD sur les paniers.
 */
@Path("/paniers")
public class PanierController {

    private PanierService panierService;

    public PanierController() {
        this.panierService = new PanierService();
    }

    /**
     * Crée un nouveau panier.
     * @param panier L'objet Panier contenant les informations sur le panier.
     * @return L'objet Panier créé.
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createPanier(Panier panier) {
        Panier createdPanier = panierService.createPanier(panier);
        return Response.status(Response.Status.CREATED).entity(createdPanier).build();
    }



    /**
     * Récupère la liste de tous les paniers.
     * @return La liste des paniers sous forme d'objet List<Panier>.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPaniers() {
        List<Panier> paniers = panierService.getPaniers();
        return Response.ok(paniers).build();
    }

    /**
     * Récupère un panier spécifique en utilisant son identifiant.
     * @param id L'identifiant du panier.
     * @return L'objet Panier correspondant à l'identifiant donné.
     */
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPanierById(@PathParam("id") Long id) {
        Panier panier = panierService.getPanierById(id);
        if (panier != null) {
            return Response.ok(panier).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    /**
     * Met à jour un panier existant.
     * @param id L'identifiant du panier à mettre à jour.
     * @param updatedPanier L'objet Panier contenant les nouvelles informations du panier.
     * @return L'objet Panier mis à jour.
     */
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updatePanier(@PathParam("id") Long id, Panier updatedPanier) {
        Panier panier = panierService.updatePanier(id, updatedPanier);
        if (panier != null) {
            return Response.ok(panier).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    /**
     * Supprime un panier existant.
     * @param id L'identifiant du panier à supprimer.
     * @return Une réponse HTTP 204 si le panier a été supprimé, une réponse HTTP 404 si le panier n'a pas été trouvé.
     */
    @DELETE
    @Path("/{id}")
    public Response deletePanier(@PathParam("id") Long id) {
        if (panierService.deletePanier(id)) {
            return Response.status(Response.Status.NO_CONTENT).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
