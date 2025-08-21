package com.jpstechno.gest_actifs_backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.jpstechno.gest_actifs_backend.dao.CategorieRepo;
import com.jpstechno.gest_actifs_backend.modeles.Categories;
import com.jpstechno.gest_actifs_backend.servicesInterfaces.CategorieInterf;

@Service
public class CategorieServ implements CategorieInterf {

    @Autowired
    private CategorieRepo categorieRepo;

    @Override
    public Categories EnregistrerCategorie(Categories categorie) {
        return categorieRepo.save(categorie);
    }

    @Override
    public List<Categories> allCategories() {
        Sort trieAppelation = Sort.by(Sort.Direction.ASC, "categorieAppelation");
        return categorieRepo.findAll(trieAppelation);
    }

}
