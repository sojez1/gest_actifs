package com.jpstechno.gest_actifs_backend.servicesInterfaces;

import java.util.List;

import com.jpstechno.gest_actifs_backend.modeles.Compteurs;
import com.jpstechno.gest_actifs_backend.modeles.Materiels;

public interface MaterielInterf {

    Materiels saveMateriel(Materiels materiel);

    Materiels updateMateriel(Long id, Materiels materiel);

    List<Materiels> listMateriels();

    void deleteMateriel(Long materiel_id);

    Materiels changerCompteur(Long materiel_id, Compteurs newCompteur);

    Materiels rechercheParCodeInterne(String codeInterne);

    List<Materiels> rechercheParAppelation(String appelation);

}
