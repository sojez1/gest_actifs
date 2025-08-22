package com.jpstechno.gest_actifs_backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpstechno.gest_actifs_backend.dao.CompteurRepo;
import com.jpstechno.gest_actifs_backend.modeles.Compteurs;
import com.jpstechno.gest_actifs_backend.servicesInterfaces.CompteurInterf;

@Service
public class CompteurServ implements CompteurInterf {

    @Autowired
    private CompteurRepo compteurRepo;

    @Override
    public Compteurs createCompteur(Compteurs compteur) {
        return compteurRepo.save(compteur);
    }

    @Override
    public Compteurs modifierCompteur(Long id, Compteurs compteur) {
        return null;
    }

}
