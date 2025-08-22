package com.jpstechno.gest_actifs_backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpstechno.gest_actifs_backend.modeles.Materiels;
import java.util.List;
import java.util.Optional;

@Repository
public interface MaterielRepo extends JpaRepository<Materiels, Long> {

    Optional<Materiels> findByInterneCode(String interneCode);

    List<Materiels> findByAppelationContainingIgnoreCase(String appelation);

}
