package com.cooperatives.paniers.repository;

import com.cooperatives.paniers.models.Panier;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class PanierRepository {

    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("cooperativePU");
    private EntityManager entityManager = entityManagerFactory.createEntityManager();

    public Panier save(Panier panier) {
        entityManager.getTransaction().begin();
        entityManager.persist(panier);
        entityManager.getTransaction().commit();
        return panier;
    }

    public List<Panier> findAll() {
        TypedQuery<Panier> query = entityManager.createQuery("select p from Panier p", Panier.class);
        return query.getResultList();
    }

    public Panier findById(Long id) {
        return entityManager.find(Panier.class, id);
    }

    public Panier update(Panier panier) {
        entityManager.getTransaction().begin();
        entityManager.merge(panier);
        entityManager.getTransaction().commit();
        return panier;
    }

    public void delete(Panier panier) {
        entityManager.getTransaction().begin();
        entityManager.remove(panier);
        entityManager.getTransaction().commit();
    }}
