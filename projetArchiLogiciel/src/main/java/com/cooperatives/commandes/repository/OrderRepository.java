package com.cooperatives.commandes.repository;

import com.cooperatives.commandes.models.Order;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import java.util.List;

/**
 * Repository pour la gestion des opérations  sur les commandes.
 */
public class OrderRepository {

    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("cooperativePU");
    private EntityManager entityManager = entityManagerFactory.createEntityManager();

    /**
     * Enregistre une nouvelle commande.
     * @param order L'objet Order à enregistrer.
     * @return L'objet Order enregistré.
     */
    public Order save(Order order) {
        entityManager.getTransaction().begin();
        entityManager.persist(order);
        entityManager.getTransaction().commit();
        return order;
    }

    /**
     * Récupère la liste de toutes les commandes.
     * @return La liste des commandes sous forme d'objet List<Order>.
     */
    public List<Order> findAll() {
        TypedQuery<Order> query = entityManager.createQuery("SELECT o FROM Order o", Order.class);
        return query.getResultList();
    }

    /**
     * Récupère une commande spécifique en utilisant son identifiant.
     * @param id L'identifiant de la commande.
     * @return L'objet Order correspondant à l'identifiant donné.
     */
    public Order findById(Long id) {
        return entityManager.find(Order.class, id);
    }

    /**
     * Met à jour une commande existante.
     * @param order L'objet Order contenant les nouvelles informations de la commande.
     * @return L'objet Order mis à jour.
     */
    public Order update(Order order) {
        entityManager.getTransaction().begin();
        entityManager.merge(order);
        entityManager.getTransaction().commit();
        return order;
    }

    /**
     * Supprime une commande existante.
     * @param id L'identifiant de la commande à supprimer.
     */
    public void delete(Long id) {
        Order order = findById(id);
        if (order != null) {
            entityManager.getTransaction().begin();
            entityManager.remove(order);
            entityManager.getTransaction().commit();
        }}
}
