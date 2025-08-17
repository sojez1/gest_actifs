package com.jpstechno.gest_actifs_backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.jpstechno.gest_actifs_backend.dao.MaterielRepo;
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

}
