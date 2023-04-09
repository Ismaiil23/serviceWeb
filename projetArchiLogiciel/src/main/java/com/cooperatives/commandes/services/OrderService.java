package com.cooperatives.commandes.services;

import com.cooperatives.commandes.models.Order;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import java.util.List;

/**
 * Service de gestion des opérations sur les commandes.
 */
public class OrderService {

    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("commandesPU");
    private EntityManager em = entityManagerFactory.createEntityManager();
    /**
     * Crée une nouvelle commande.
     * @param order L'objet Order contenant les informations sur la commande.
     * @return L'objet Order créé.
     */
    public Order createOrder(Order order) {
        em.getTransaction().begin();
        em.persist(order);
        em.getTransaction().commit();
        return order;
    }

    /**
     * Récupère la liste de toutes les commandes.
     * @return La liste des commandes sous forme d'objet List<Order>.
     */
    public List<Order> getAllOrders() {
        return em.createQuery("SELECT o FROM Order o", Order.class).getResultList();
    }

    /**
     * Récupère une commande spécifique en utilisant son identifiant.
     * @param id L'identifiant de la commande.
     * @return L'objet Order correspondant à l'identifiant donné.
     */
    public Order getOrderById(Long id) {
        return em.find(Order.class, id);
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
        em.getTransaction().begin();
        Order updatedOrder = em.merge(order);
        em.getTransaction().commit();
        return updatedOrder;
    }

    /**
     * Supprime une commande existante.
     * @param id L'identifiant de la commande à supprimer.
     */
    public void deleteOrder(Long id) {
        Order existingOrder = getOrderById(id);
        if (existingOrder != null) {
            em.getTransaction().begin();
            em.remove(existingOrder);
            em.getTransaction().commit();
        }
    }
}
