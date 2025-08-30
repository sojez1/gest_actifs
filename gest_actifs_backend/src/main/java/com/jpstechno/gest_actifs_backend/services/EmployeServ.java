package com.jpstechno.gest_actifs_backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jpstechno.gest_actifs_backend.dao.EmployeRepo;
import com.jpstechno.gest_actifs_backend.modeles.Employes;
import com.jpstechno.gest_actifs_backend.modeles.Roles;
import com.jpstechno.gest_actifs_backend.servicesInterfaces.EmployesInterf;

@Service
public class EmployeServ implements EmployesInterf {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    private EmployeRepo employeRepo;

    EmployeServ(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Employes inscrireEmploye(Employes employe) {
        employe.setPassword(passwordEncoder.encode(employe.getPassword()));
        return employeRepo.save(employe);
    }

    @Override
    public Employes changerStatutEmploye(Long id) {
        Employes employeConcerne = employeRepo.findById(id).orElseThrow();
        boolean statut = employeConcerne.isEmployeActif();
        employeConcerne.setEmployeActif(!statut);
        return employeRepo.save(employeConcerne);
    }

    @Override
    public List<Employes> listeDesEmployes() {
        Sort trieParNom = Sort.by(Sort.Direction.ASC, "nom");
        return employeRepo.findAll(trieParNom);
    }

    @Override
    public Employes updateRole(Long employe_id, Roles roles) {
        throw new UnsupportedOperationException("Unimplemented method 'updateRole'");
    }

}
