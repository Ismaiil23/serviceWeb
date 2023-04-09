package com.cooperatives.commandes.controllers;

import com.cooperatives.commandes.models.Order;
import com.cooperatives.commandes.services.OrderService;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

/**
 * Contrôleur pour les opérations sur les commandes.
 */
@Path("/orders")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OrderController {

    @Inject
    private OrderService orderService;

    /**
     * Crée une nouvelle commande.
     * @param order L'objet Order contenant les informations sur la commande.
     * @return L'objet Order créé.
     */
    @POST
    public Order createOrder(Order order) {
        return orderService.createOrder(order);
    }

    /**
     * Récupère la liste de toutes les commandes.
     * @return La liste des commandes sous forme d'objet List<Order>.
     */
    @GET
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    /**
     * Récupère une commande spécifique en utilisant son identifiant.
     * @param id L'identifiant de la commande.
     * @return L'objet Order correspondant à l'identifiant donné.
     */
    @GET
    @Path("/{id}")
    public Order getOrderById(@PathParam("id") Long id) {
        return orderService.getOrderById(id);
    }

    /**
     * Met à jour une commande existante.
     * @param id L'identifiant de la commande à mettre à jour.
     * @param order L'objet Order contenant les nouvelles informations de la commande.
     * @return L'objet Order mis à jour.
     */
    @PUT
    @Path("/{id}")
    public Order updateOrder(@PathParam("id") Long id, Order order) {
        return orderService.updateOrder(id, order);
    }

    /**
     * Supprime une commande existante.
     * @param id L'identifiant de la commande à supprimer.
     */
    @DELETE
    @Path("/{id}")
    public void deleteOrder(@PathParam("id") Long id) {
        orderService.deleteOrder(id);
    }
}
