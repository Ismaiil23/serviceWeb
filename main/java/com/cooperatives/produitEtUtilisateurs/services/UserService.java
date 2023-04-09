/**

 Cette classe est un service qui gère les utilisateurs en utilisant un objet UserRepository.
 */
package com.cooperatives.produitEtUtilisateurs.services;

import com.cooperatives.produitEtUtilisateurs.models.User;
import com.cooperatives.produitEtUtilisateurs.repository.UserRepository;

import jakarta.inject.Inject;
import java.util.List;

public class UserService {
    @Inject
    private UserRepository userRepository;

    /**
     * Cette méthode crée un utilisateur en utilisant la méthode save() de UserRepository.
     * @param user l'utilisateur à créer.
     * @return l'utilisateur créé.
     */
    public User createUser(User user) {
        return userRepository.save(user);
    }

    /**
     * Cette méthode retourne une liste de tous les utilisateurs en utilisant la méthode findAll() de UserRepository.
     * @return une liste de tous les utilisateurs.
     */
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    /**
     * Cette méthode retourne un utilisateur en utilisant la méthode findById() de UserRepository.
     * @param id l'ID de l'utilisateur à récupérer.
     * @return l'utilisateur correspondant à l'ID.
     */
    public User getUserById(Long id) {
        return userRepository.findById(id);
    }

    /**
     * Cette méthode met à jour un utilisateur existant en utilisant la méthode update() de UserRepository.
     * @param id l'ID de l'utilisateur à mettre à jour.
     * @param user l'utilisateur avec les nouvelles informations.
     * @return l'utilisateur mis à jour.
     */
    public User updateUser(Long id, User user) {
        User existingUser = userRepository.findById(id);
        if (existingUser != null) {
            user.setId(id);
            return userRepository.update(user);
        }
        return null;
    }

    /**
     * Cette méthode supprime un utilisateur en utilisant la méthode delete() de UserRepository.
     * @param id l'ID de l'utilisateur à supprimer.
     * @return true si l'utilisateur a été supprimé avec succès, false sinon.
     */
    public boolean deleteUser(Long id) {
        User user = userRepository.findById(id);
        if (user != null) {
            userRepository.delete(user);
            return true;
        }
        return false;
    }

}