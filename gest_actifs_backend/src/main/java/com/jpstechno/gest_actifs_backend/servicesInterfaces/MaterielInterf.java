package com.jpstechno.gest_actifs_backend.servicesInterfaces;

import java.util.List;

import com.jpstechno.gest_actifs_backend.modeles.Compteurs;
import com.jpstechno.gest_actifs_backend.modeles.Materiels;

public interface MaterielInterf {

    Materiels saveMateriel(Materiels materiel, String unitCompteur);

    Materiels updateMateriel(Materiels materiel, long oldMateriel_id);

    List<Materiels> listMateriels();

    void deleteMateriel(Long materiel_id);

    Materiels changerCompteur(Long idMateriel, Compteurs newCompteur);

}
