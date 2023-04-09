package com.cooperatives.produitEtUtilisateurs.repository;

import com.cooperatives.produitEtUtilisateurs.models.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class UserRepository {

    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("cooperativePU");
    private EntityManager entityManager = entityManagerFactory.createEntityManager();

    /**
     * Ajoute un utilisateur à la base de données.
     * @param user L'utilisateur à ajouter.
     * @return L'utilisateur ajouté.
     */
    public User save(User user) {
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
        return user;
    }

    /**
     * Récupère tous les utilisateurs de la base de données.
     * @return Une liste contenant tous les utilisateurs de la base de données.
     */
    public List<User> findAll() {
        TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u", User.class);
        return query.getResultList();
    }

    /**
     * Récupère un utilisateur à partir de son identifiant.
     * @param id L'identifiant de l'utilisateur.
     * @return L'utilisateur correspondant à l'identifiant spécifié, ou null si aucun utilisateur correspondant n'est trouvé.
     */
    public User findById(Long id) {
        return entityManager.find(User.class, id);
    }

    /**
     * Met à jour un utilisateur existant dans la base de données.
     * @param user L'utilisateur à mettre à jour.
     * @return L'utilisateur mis à jour.
     */
    public User update(User user) {
        entityManager.getTransaction().begin();
        entityManager.merge(user);
        entityManager.getTransaction().commit();
        return user;
    }

    /**
     * Supprime un utilisateur de la base de données.
     * @param user L'utilisateur à supprimer.
     */
    public void delete(User user) {
        entityManager.getTransaction().begin();
        entityManager.remove(user);
        entityManager.getTransaction().commit();
    }
}

