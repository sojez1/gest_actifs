package com.jpstechno.gest_actifs_backend.securities;

import java.util.List;

import com.jpstechno.gest_actifs_backend.modeles.Employes;
import com.jpstechno.gest_actifs_backend.modeles.Roles;

/**
 * Enreggistrement sert a sauvegarder les donnees de l'employe au authentifier
 * sans son mot de passe.
 * A utiliseer cote front-end pour ne pas exposer le mot de passe de
 * l'utilisateur dans les cookies ou jwt
 */

public record Utilisateurs(String email, String nom, String prenom, List<Roles> roles, long id, boolean isActif) {

    public static Utilisateurs convertEmployeToUtilisateur(Employes employe) {
        return new Utilisateurs(employe.getEmail(), employe.getNom(), employe.getPrenom(), employe.getRole(),
                employe.getId(), employe.isEmployeActif());
    }

}
