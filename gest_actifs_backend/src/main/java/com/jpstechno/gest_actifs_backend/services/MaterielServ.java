package com.jpstechno.gest_actifs_backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.jpstechno.gest_actifs_backend.dao.CompteurRepo;
import com.jpstechno.gest_actifs_backend.dao.MaterielRepo;
import com.jpstechno.gest_actifs_backend.modeles.Compteurs;
import com.jpstechno.gest_actifs_backend.modeles.Materiels;
import com.jpstechno.gest_actifs_backend.servicesInterfaces.MaterielInterf;

import jakarta.transaction.Transactional;

@Service
public class MaterielServ implements MaterielInterf {

    @Autowired
    private MaterielRepo mater_repo;

    @Autowired
    private CompteurRepo compteurRepo;

    @Autowired
    private CompteurServ computerServ;

    @Override
    @Transactional
    public Materiels saveMateriel(Materiels materiel, String unitCompteur) {

        // create counter to mount on the materiel
        Compteurs firstCompteur = new Compteurs();
        firstCompteur.setUnits(unitCompteur);
        firstCompteur.setMateriel(materiel);
        compteurRepo.save(firstCompteur);

        // Associate the new Compteur to the materiels
        materiel.setCompteurActif(firstCompteur);
        return mater_repo.save(materiel);

    }

    @Override
    public Materiels updateMateriel(Materiels materiel, long oldMateriel_id) {
        return null;

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

        // update the old counter by disable it.
        Materiels toBeUpdated = mater_repo.findById(idMateriel).orElseThrow();
        computerServ.changeStatut(toBeUpdated); // to desactivate the current Compteur

        // mount the new counter on the material
        toBeUpdated.setCompteurActif(newCompteur);
        return mater_repo.save(toBeUpdated);
    }

}
