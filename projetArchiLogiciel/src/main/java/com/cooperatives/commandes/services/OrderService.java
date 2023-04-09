package com.cooperatives.commandes.services;

import com.cooperatives.commandes.models.Order;
import com.cooperatives.commandes.repository.OrderRepository;

import javax.inject.Inject;
import java.util.List;

public class OrderService {

    @Inject
    private OrderRepository orderRepository;

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    public Order updateOrder(Long id, Order order) {
        Order existingOrder = getOrderById(id);
        if (existingOrder == null) {
            return null;
        }
        order.setId(id);
        return orderRepository.update(order);
    }

    public void deleteOrder(Long id) {
        orderRepository.delete(id);
    }



}
