package com.cooperatives.paniers.services;

import com.cooperatives.paniers.models.Panier;
import com.cooperatives.paniers.repository.PanierRepository;

import java.util.List;

public class PanierService {

    private PanierRepository panierRepository;

    /**
     * Initialise un nouveau PanierRepository.
     */
    public PanierService() {
        this.panierRepository = new PanierRepository();
    }

    /**
     * Crée un nouveau panier.
     *
     * @param panier Le panier à créer.
     * @return Le panier créé.
     */
    public Panier createPanier(Panier panier) {
        return panierRepository.save(panier);
    }

    /**
     * Récupère la liste de tous les paniers.
     *
     * @return La liste de tous les paniers.
     */
    public List<Panier> getPaniers() {
        return panierRepository.findAll();
    }

    /**
     * Récupère un panier par son ID.
     *
     * @param id L'ID du panier à récupérer.
     * @return Le panier correspondant à l'ID spécifié, ou null s'il n'existe pas.
     */
    public Panier getPanierById(Long id) {
        return panierRepository.findById(id);
    }

    /**
     * Met à jour un panier existant.
     *
     * @param id L'ID du panier à mettre à jour.
     * @param updatedPanier Le panier avec les données mises à jour.
     * @return Le panier mis à jour, ou null s'il n'existe pas.
     */
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

    /**
     * Supprime un panier existant.
     *
     * @param id L'ID du panier à supprimer.
     * @return true si le panier a été supprimé, false s'il n'existe pas.
     */
    public boolean deletePanier(Long id) {
        Panier existingPanier = panierRepository.findById(id);
        if (existingPanier != null) {
            panierRepository.delete(existingPanier);
            return true;
        }
        return false;
    }
}
