/**

 Cette classe gère l'interaction avec la base de données pour les objets Product.
 */
package com.cooperatives.produitEtUtilisateurs.repository;

import com.cooperatives.produitEtUtilisateurs.models.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class ProductRepository {
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("cooperativePU");
    private EntityManager entityManager = entityManagerFactory.createEntityManager();

    /**
     * Enregistre un objet Product dans la base de données.
     *
     * @param product l'objet Product à enregistrer
     * @return l'objet Product enregistré
     */
    public Product save(Product product) {
        entityManager.getTransaction().begin();
        entityManager.persist(product);
        entityManager.getTransaction().commit();
        return product;
    }

    /**
     * Récupère tous les objets Product enregistrés dans la base de données.
     *
     * @return une liste contenant tous les objets Product enregistrés
     */
    public List<Product> findAll() {
        TypedQuery<Product> query = entityManager.createQuery("SELECT p FROM Product p", Product.class);
        return query.getResultList();
    }

    /**
     * Récupère un objet Product enregistré dans la base de données en utilisant son ID.
     *
     * @param id l'ID de l'objet Product à récupérer
     * @return l'objet Product récupéré ou null si l'objet n'existe pas dans la base de données
     */
    public Product findById(Long id) {
        return entityManager.find(Product.class, id);
    }

    /**
     * Met à jour un objet Product enregistré dans la base de données.
     *
     * @param product l'objet Product à mettre à jour
     * @return l'objet Product mis à jour
     */
    public Product update(Product product) {
        entityManager.getTransaction().begin();
        entityManager.merge(product);
        entityManager.getTransaction().commit();
        return product;
    }

    /**
     * Supprime un objet Product de la base de données.
     *
     * @param product l'objet Product à supprimer
     */
    public void delete(Product product) {
        entityManager.getTransaction().begin();
        entityManager.remove(product);
        entityManager.getTransaction().commit();
    }
}