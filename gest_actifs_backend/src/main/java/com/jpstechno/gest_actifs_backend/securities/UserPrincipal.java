package com.jpstechno.gest_actifs_backend.securities;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.jpstechno.gest_actifs_backend.modeles.Employes;

public class UserPrincipal implements UserDetails {

    private Employes utilisateur;

    public UserPrincipal(Employes empl) {
        this.utilisateur = empl;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority("USER"));
    }

    @Override
    public String getPassword() {
        return utilisateur.getPassword();
    }

    @Override
    public String getUsername() {
        return utilisateur.getEmail();
    }

}
