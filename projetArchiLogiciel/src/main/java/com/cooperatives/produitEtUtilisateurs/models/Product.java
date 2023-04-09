package com.cooperatives.produitEtUtilisateurs.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**

 Classe représentant un produit vendu par une coopérative.
 Cette classe utilise les annotations JPA pour la persistance des données en base de données.
 Elle est caractérisée par les propriétés suivantes :
 id : l'identifiant unique du produit
 name : le nom du produit
 description : la description du produit
 price : le prix unitaire du produit
 unit : l'unité de mesure du produit (ex : "kg", "l", "pièce", etc.)
 Les getters et setters sont fournis pour accéder et modifier les propriétés de la classe.
 */

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private double price;
    private String unit;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getUnit() {
        return unit;
    }


    public void setUnit(String unit) {
        this.unit = unit;
    }




}
