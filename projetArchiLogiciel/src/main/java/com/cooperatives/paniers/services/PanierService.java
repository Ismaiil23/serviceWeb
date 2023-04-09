package com.cooperatives.paniers.services;

import com.cooperatives.paniers.models.Panier;
import com.cooperatives.paniers.repository.PanierRepository;

import java.util.List;

public class PanierService {

    private PanierRepository panierRepository;

    public PanierService() {
        this.panierRepository = new PanierRepository();
    }

    public Panier createPanier(Panier panier) {
        return panierRepository.save(panier);
    }

    public List<Panier> getPaniers() {
        return panierRepository.findAll();
    }

    public Panier getPanierById(Long id) {
        return panierRepository.findById(id);
    }

    public Panier updatePanier(Long id, Panier updatedPanier) {
        Panier existingPanier = panierRepository.findById(id);
        if (existingPanier != null) {
            existingPanier.setUserId(updatedPanier.getUserId());
            existingPanier.setLastUpdate(updatedPanier.getLastUpdate());
            existingPanier.setValidated(updatedPanier.isValidated());
            existingPanier.setProducts(updatedPanier.getProducts());
            return panierRepository.update(existingPanier);
        }
        return null;
    }

    public boolean deletePanier(Long id) {
        Panier existingPanier = panierRepository.findById(id);
        if (existingPanier != null) {
            panierRepository.delete(existingPanier);
            return true;
        }
        return false;
    }
}
