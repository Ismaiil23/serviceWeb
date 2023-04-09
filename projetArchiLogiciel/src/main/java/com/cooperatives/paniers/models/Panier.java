package com.cooperatives.paniers.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import java.util.Map;

/**

 Classe représentant un panier d'achat pour un utilisateur.
 Cette classe utilise les annotations JPA pour la persistance des données en base de données.
 Elle est caractérisée par les propriétés suivantes :
 id : l'identifiant unique du panier
 userId : l'identifiant de l'utilisateur propriétaire du panier
 lastUpdate : la date et l'heure de la dernière mise à jour du panier
 isValidated : un booléen indiquant si le panier a été validé pour l'achat
 products : une map associant l'identifiant unique de chaque produit présent dans le panier avec sa quantité
 Les getters et setters sont fournis pour accéder et modifier les propriétés de la classe.
 */

@Entity
public class Panier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private LocalDateTime lastUpdate;
    private boolean isValidated;
    private Map<Long, Integer> products; // Clé : ID du produit, Valeur : Quantité

// Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public boolean isValidated() {
        return isValidated;
    }

    public void setValidated(boolean validated) {
        isValidated = validated;
    }

    public Map<Long, Integer> getProducts() {
        return products;
    }

    public void setProducts(Map<Long, Integer> products) {
        this.products = products;
    }

}