package com.jpstechno.gest_actifs_backend.controlleurs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jpstechno.gest_actifs_backend.modeles.Materiels;
import com.jpstechno.gest_actifs_backend.services.MaterielServ;

@RestController
public class MaterielControl {

    @Autowired
    private MaterielServ mateServ;

    @PostMapping("/materiel/insert_materiel")
    public Materiels insertMateriel(@RequestBody Materiels materiel) {
        return mateServ.saveMateriel(materiel);
    }

    @GetMapping("materiels/get_all")
    public List<Materiels> getAllMateriel() {
        return mateServ.listMateriels();
    }

}
