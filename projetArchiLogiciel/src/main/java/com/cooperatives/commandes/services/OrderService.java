package com.cooperatives.commandes.services;

import com.cooperatives.commandes.models.Order;
import com.cooperatives.commandes.repository.OrderRepository;

import jakarta.inject.Inject;
import java.util.List;

/**
 * Service de gestion des opérations sur les commandes.
 */
public class OrderService {

    @Inject
    private OrderRepository orderRepository;

    /**
     * Crée une nouvelle commande.
     * @param order L'objet Order contenant les informations sur la commande.
     * @return L'objet Order créé.
     */
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    /**
     * Récupère la liste de toutes les commandes.
     * @return La liste des commandes sous forme d'objet List<Order>.
     */
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    /**
     * Récupère une commande spécifique en utilisant son identifiant.
     * @param id L'identifiant de la commande.
     * @return L'objet Order correspondant à l'identifiant donné.
     */
    public Order getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    /**
     * Met à jour une commande existante.
     * @param id L'identifiant de la commande à mettre à jour.
     * @param order L'objet Order contenant les nouvelles informations de la commande.
     * @return L'objet Order mis à jour.
     */
    public Order updateOrder(Long id, Order order) {
        Order existingOrder = getOrderById(id);
        if (existingOrder == null) {
            return null;
        }
        order.setId(id);
        return orderRepository.update(order);
    }

    /**
     * Supprime une commande existante.
     * @param id L'identifiant de la commande à supprimer.
     */
    public void deleteOrder(Long id) {
        orderRepository.delete(id);
    }



}
