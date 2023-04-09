package com.cooperatives.paniers.api;

import com.cooperatives.paniers.models.Panier;
import com.cooperatives.paniers.services.PanierService;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/paniers")
public class PanierResource {

    private PanierService panierService;

    public PanierResource() {
        this.panierService = new PanierService();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createPanier(Panier panier) {
        Panier createdPanier = panierService.createPanier(panier);
        return Response.status(Response.Status.CREATED).entity(createdPanier).build();
    }


    // Ajoutez d'autres endpoints pour les opérations CRUD (get, update, delete)

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPaniers() {
        List<Panier> paniers = panierService.getPaniers();
        return Response.ok(paniers).build();
    }

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
