package com.jpstechno.gest_actifs_backend.servicesInterfaces;

import com.jpstechno.gest_actifs_backend.modeles.Compteurs;

public interface CompteurInterf {

    Compteurs createCompteur(Compteurs compteur);

    Compteurs modifierCompteur(Long id, Compteurs compteur);

}
