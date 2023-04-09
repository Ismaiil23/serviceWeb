package com.cooperatives.paniers.repository;

import com.cooperatives.paniers.models.Panier;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class PanierRepository {

    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("paniersPU");
    private EntityManager entityManager = entityManagerFactory.createEntityManager();

    /**
     * Sauvegarde le panier donné en argument dans la base de données.
     *
     * @param panier le panier à sauvegarder
     * @return le panier sauvegardé
     */
    public Panier save(Panier panier) {
        entityManager.getTransaction().begin();
        entityManager.persist(panier);
        entityManager.getTransaction().commit();
        return panier;
    }

    /**
     * Récupère tous les paniers stockés dans la base de données.
     *
     * @return la liste de tous les paniers stockés
     */
    public List<Panier> findAll() {
        TypedQuery<Panier> query = entityManager.createQuery("select p from Panier p", Panier.class);
        return query.getResultList();
    }

    /**
     * Récupère le panier correspondant à l'identifiant donné en argument.
     *
     * @param id l'identifiant du panier à récupérer
     * @return le panier correspondant à l'identifiant donné, ou null si aucun panier ne correspond
     */
    public Panier findById(Long id) {
        return entityManager.find(Panier.class, id);
    }

    /**
     * Met à jour le panier donné en argument dans la base de données.
     *
     * @param panier le panier à mettre à jour
     * @return le panier mis à jour
     */
    public Panier update(Panier panier) {
        entityManager.getTransaction().begin();
        entityManager.merge(panier);
        entityManager.getTransaction().commit();
        return panier;
    }

    /**
     * Supprime le panier donné en argument de la base de données.
     *
     * @param panier le panier à supprimer
     */
    public void delete(Panier panier) {
        entityManager.getTransaction().begin();
        entityManager.remove(panier);
        entityManager.getTransaction().commit();
    }
}
