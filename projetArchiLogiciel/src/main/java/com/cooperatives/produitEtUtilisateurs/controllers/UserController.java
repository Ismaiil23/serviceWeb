/**

 Le contrôleur qui gère les requêtes HTTP liées aux utilisateurs.
 */
package com.cooperatives.produitEtUtilisateurs.controllers;

import com.cooperatives.produitEtUtilisateurs.models.User;
import com.cooperatives.produitEtUtilisateurs.services.UserService;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserController {
    @Inject
    private UserService userService;

    /**
     * Crée un nouvel utilisateur.
     *
     * @param user l'utilisateur à créer.
     * @return l'utilisateur créé.
     */
    @POST
    public User createUser(User user) {
        return userService.createUser(user);
    }

    /**
     * Récupère tous les utilisateurs existants.
     *
     * @return la liste des utilisateurs.
     */
    @GET
    public List<User> getUsers() {
        return userService.getUsers();
    }

    /**
     * Récupère un utilisateur par son identifiant.
     *
     * @param id l'identifiant de l'utilisateur à récupérer.
     * @return l'utilisateur correspondant à l'identifiant spécifié.
     */
    @GET
    @Path("/{id}")
    public User getUserById(@PathParam("id") Long id) {
        return userService.getUserById(id);
    }

    /**
     * Met à jour un utilisateur existant.
     *
     * @param id   l'identifiant de l'utilisateur à mettre à jour.
     * @param user les nouvelles informations de l'utilisateur.
     * @return l'utilisateur mis à jour.
     */
    @PUT
    @Path("/{id}")
    public User updateUser(@PathParam("id") Long id, User user) {
        return userService.updateUser(id, user);
    }

    /**
     * Supprime un utilisateur existant.
     *
     * @param id l'identifiant de l'utilisateur à supprimer.
     * @return une réponse HTTP appropriée selon que l'utilisateur a été supprimé avec succès ou non.
     */
    @DELETE
    @Path("/{id}")
    public Response deleteUser(@PathParam("id") Long id) {
        if (userService.deleteUser(id)) {
            return Response.status(Response.Status.NO_CONTENT).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

}