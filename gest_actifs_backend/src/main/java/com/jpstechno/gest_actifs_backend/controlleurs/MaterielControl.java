package com.jpstechno.gest_actifs_backend.controlleurs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpstechno.gest_actifs_backend.modeles.Categories;
import com.jpstechno.gest_actifs_backend.modeles.Materiels;
import com.jpstechno.gest_actifs_backend.services.CategorieServ;
import com.jpstechno.gest_actifs_backend.services.MaterielServ;

@RestController
@RequestMapping("materiels")
@CrossOrigin
public class MaterielControl {

    @Autowired
    private MaterielServ mateServ;

    @Autowired
    private CategorieServ categorieServ;

    // Categorie API

    @PostMapping("/categories")
    public Categories addCategorie(@RequestBody Categories categorie) {
        return categorieServ.EnregistrerCategorie(categorie);
    }

    @PreAuthorize("hasRole('ROLe_USER')")
    @GetMapping("/categories")
    public List<Categories> listeCategories() {
        return categorieServ.allCategories();
    }

    // materiel API

    @PostMapping("/insert_materiel")
    public Materiels insertMateriel(@RequestBody Materiels materiel, @RequestBody String unitCompteur) {
        return mateServ.saveMateriel(materiel, unitCompteur);
    }

    @GetMapping("materiels/get_all")
    public List<Materiels> getAllMateriel() {
        return mateServ.listMateriels();
    }

}
