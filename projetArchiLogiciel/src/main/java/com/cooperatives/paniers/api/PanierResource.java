package com.cooperatives.paniers.api;

import com.cooperatives.paniers.models.Panier;
import com.cooperatives.paniers.services.PanierService;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

/**
 * Cette classe définit les endpoints de l'API REST pour les paniers
 */
@Path("/paniers")
public class PanierResource {

    private PanierService panierService;

    /**
     * Constructeur qui initialise le service PanierService
     */
    public PanierResource() {
        this.panierService = new PanierService();
    }

    /**
     * Endpoint pour créer un nouveau panier
     *
     * @param panier Le panier à créer
     * @return La réponse HTTP avec le panier créé au format JSON
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createPanier(Panier panier) {
        Panier createdPanier = panierService.createPanier(panier);
        return Response.status(Response.Status.CREATED).entity(createdPanier).build();
    }


    // Ajoutez d'autres endpoints pour les opérations CRUD (get, update, delete)

    /**
     * Endpoint pour récupérer tous les paniers
     *
     * @return La réponse HTTP avec la liste des paniers au format JSON
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPaniers() {
        List<Panier> paniers = panierService.getPaniers();
        return Response.ok(paniers).build();
    }

    /**
     * Endpoint pour récupérer un panier par son identifiant
     *
     * @param id L'identifiant du panier à récupérer
     * @return La réponse HTTP avec le panier correspondant au format JSON, ou une réponse NOT FOUND si le panier n'existe pas
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
     * Endpoint pour mettre à jour un panier existant
     *
     * @param id            L'identifiant du panier à mettre à jour
     * @param updatedPanier Le panier mis à jour
     * @return La réponse HTTP avec le panier mis à jour au format JSON, ou une réponse NOT FOUND si le panier n'existe pas
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
 * Endpoint pour supprimer un panier existant
 * @param id L'identifiant du panier à supprimer
 * @return La réponse HTTP avec le statut NO CONTENT si le panier a été supprimé, ou une réponse NOT FOUND si le panier n'existe pas
 */

    /**
     * Endpoint pour supprimer un panier existant en utilisant son ID.
     *
     * @param id L'ID du panier à supprimer
     * @return La réponse HTTP avec le statut NO CONTENT si le panier a été supprimé, ou une réponse NOT FOUND si le panier n'existe pas
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