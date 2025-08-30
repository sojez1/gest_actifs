package com.jpstechno.gest_actifs_backend.servicesInterfaces;

import java.util.List;

import com.jpstechno.gest_actifs_backend.modeles.Employes;
import com.jpstechno.gest_actifs_backend.modeles.Roles;

public interface EmployesInterf {

    Employes inscrireEmploye(Employes employe);

    Employes changerStatutEmploye(Long id);

    List<Employes> listeDesEmployes();

    Employes updateRole(Long employe_id, Roles roles);
}
