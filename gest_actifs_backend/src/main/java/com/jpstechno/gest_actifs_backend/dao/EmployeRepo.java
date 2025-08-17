package com.jpstechno.gest_actifs_backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpstechno.gest_actifs_backend.modeles.Employes;

@Repository
public interface EmployeRepo extends JpaRepository<Employes, Long> {

}
