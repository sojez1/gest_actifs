package com.jpstechno.gest_actifs_backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpstechno.gest_actifs_backend.modeles.Materiels;

@Repository
public interface MaterielRepo extends JpaRepository<Materiels, Long> {

}
