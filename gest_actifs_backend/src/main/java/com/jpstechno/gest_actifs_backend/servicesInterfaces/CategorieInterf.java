package com.jpstechno.gest_actifs_backend.servicesInterfaces;

import java.util.List;

import com.jpstechno.gest_actifs_backend.modeles.Categories;

public interface CategorieInterf {

    Categories EnregistrerCategorie(Categories categorie);

    List<Categories> allCategories();

}
