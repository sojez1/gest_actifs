package com.jpstechno.gest_actifs_backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.jpstechno.gest_actifs_backend.dao.MaterielRepo;
import com.jpstechno.gest_actifs_backend.modeles.Compteurs;
import com.jpstechno.gest_actifs_backend.modeles.Materiels;
import com.jpstechno.gest_actifs_backend.servicesInterfaces.MaterielInterf;

@Service
public class MaterielServ implements MaterielInterf {

    @Autowired
    private MaterielRepo mater_repo;

    @Override
    public Materiels saveMateriel(Materiels materiel) {
        return mater_repo.save(materiel);

    }

    @Override
    public Materiels updateMateriel(Long id, Materiels materiel) {
        Materiels toBeUpdated = mater_repo.findById(id).orElseThrow();
        toBeUpdated.setAppelation(materiel.getAppelation());
        toBeUpdated.setCategorie(materiel.getCategorie());
        toBeUpdated.setInterneCode(materiel.getInterneCode());
        return mater_repo.save(toBeUpdated);
    }

    @Override
    public List<Materiels> listMateriels() {
        Sort trie_appelation = Sort.by(Sort.Direction.ASC, "appelation");
        return mater_repo.findAll(trie_appelation);
    }

    @Override
    public void deleteMateriel(Long materiel_id) {
        mater_repo.deleteById(materiel_id);
    }

    @Override
    public Materiels changerCompteur(Long idMateriel, Compteurs newCompteur) {

        Materiels mate = mater_repo.findById(idMateriel).orElseThrow();

        List<Compteurs> newListe = mate.getListeCompteurs();

        // desactiver le compteur actif
        newListe.stream()
                .filter(Compteurs::isActif)
                .findFirst().orElseThrow()
                .setActif(false);

        // Ajouter le nouveau compteur

        newListe.add(newCompteur);
        mate.setListeCompteurs(newListe);

        // Update le materiel
        return mater_repo.save(mate);

    }

    @Override
    public Materiels rechercheParCodeInterne(String codeInterne) {
        return mater_repo.findByInterneCode(codeInterne).orElseThrow();
    }

    @Override
    public List<Materiels> rechercheParAppelation(String appelation) {
        return mater_repo.findByAppelationContainingIgnoreCase(appelation);
    }

}
