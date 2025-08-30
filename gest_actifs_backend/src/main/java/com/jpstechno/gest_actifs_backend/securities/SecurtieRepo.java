package com.jpstechno.gest_actifs_backend.securities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jpstechno.gest_actifs_backend.modeles.Employes;

@Repository
public interface SecurtieRepo extends JpaRepository<Employes, Long> {

    @Query("select empl from Employes empl where empl.email = ?1")
    Employes loadUserByUsername(String username);

}
