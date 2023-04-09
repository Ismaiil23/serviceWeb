package com.cooperatives.commandes.controllers;

import com.cooperatives.commandes.models.Order;
import com.cooperatives.commandes.services.OrderService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/orders")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OrderController {

    @Inject
    private OrderService orderService;

    @POST
    public Order createOrder(Order order) {
        return orderService.createOrder(order);
    }

    @GET
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GET
    @Path("/{id}")
    public Order getOrderById(@PathParam("id") Long id) {
        return orderService.getOrderById(id);
    }

    @PUT
    @Path("/{id}")
    public Order updateOrder(@PathParam("id") Long id, Order order) {
        return orderService.updateOrder(id, order);
    }

    @DELETE
    @Path("/{id}")
    public void deleteOrder(@PathParam("id") Long id) {
        orderService.deleteOrder(id);
    }
}
