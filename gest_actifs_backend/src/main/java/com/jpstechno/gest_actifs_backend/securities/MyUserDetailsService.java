package com.jpstechno.gest_actifs_backend.securities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jpstechno.gest_actifs_backend.modeles.Employes;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private SecurtieRepo utilisateurRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Employes utilisateur = utilisateurRepo.loadUserByUsername(username);
        if (utilisateur == null) {
            throw new UsernameNotFoundException("L'utilisateur n'existe pas");
        }

        return new UserPrincipal(utilisateur);

    }

}
