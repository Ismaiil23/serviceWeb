/**

 Cette classe contient les services pour gérer les produits.
 */
package com.cooperatives.produitEtUtilisateurs.services;

import com.cooperatives.produitEtUtilisateurs.models.Product;
import com.cooperatives.produitEtUtilisateurs.repository.ProductRepository;

import jakarta.inject.Inject;
import java.util.List;

public class ProductService {
    @Inject
    private ProductRepository productRepository;

    /**
     * Crée un nouveau produit.
     *
     * @param product le produit à créer.
     * @return le produit créé.
     */
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    /**
     * Récupère tous les produits.
     *
     * @return une liste de tous les produits.
     */
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    /**
     * Récupère un produit par son identifiant.
     *
     * @param id l'identifiant du produit à récupérer.
     * @return le produit correspondant à l'identifiant donné, ou null s'il n'existe pas.
     */
    public Product getProductById(Long id) {
        return productRepository.findById(id);
    }

    /**
     * Met à jour un produit existant.
     *
     * @param id l'identifiant du produit à mettre à jour.
     * @param product le produit mis à jour.
     * @return le produit mis à jour, ou null si le produit n'existe pas.
     */
    public Product updateProduct(Long id, Product product) {
        Product existingProduct = productRepository.findById(id);
        if (existingProduct != null) {
            product.setId(id);
            return productRepository.update(product);
        }
        return null;
    }

    /**
     * Supprime un produit.
     *
     * @param id l'identifiant du produit à supprimer.
     * @return true si le produit a été supprimé avec succès, false sinon.
     */
    public boolean deleteProduct(Long id) {
        Product product = productRepository.findById(id);
        if (product != null) {
            productRepository.delete(product);
            return true;
        }
        return false;
    }

}