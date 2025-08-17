package com.jpstechno.gest_actifs_backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpstechno.gest_actifs_backend.modeles.Compteurs;

@Repository
public interface CompteurRepo extends JpaRepository<Compteurs, Long> {

}
