package com.jpstechno.gest_actifs_backend.modeles;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.NaturalId;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Employes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 15)
    @NaturalId
    private String matricule;

    @Column(length = 50, nullable = false)
    private String nom;

    @Column(length = 50, nullable = false)
    private String prenom;

    @Column(nullable = false)
    private String email;

    @Column(length = 15, nullable = false)
    private String telephone;

    private String password;

    private LocalDate hiredDate;

    @Column(updatable = false)
    private LocalDate saveAt;

    @Enumerated(EnumType.STRING)
    private List<Roles> role;

    private boolean isEmployeActif;

    @OneToMany(mappedBy = "reportedBy")
    private List<BreakdownReport> listeBreakdownReported;

}
