package com.jpstechno.gest_actifs_backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpstechno.gest_actifs_backend.modeles.Categories;

@Repository
public interface CategorieRepo extends JpaRepository<Categories, Long> {

}
