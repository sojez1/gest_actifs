package com.jpstechno.gest_actifs_backend.servicesInterfaces;

import com.jpstechno.gest_actifs_backend.modeles.Compteurs;
import com.jpstechno.gest_actifs_backend.modeles.Materiels;

public interface CompteurInterf {

    Compteurs changeStatut(Materiels MaterielHavingCompteur);

}
