package com.jpstechno.gest_actifs_backend.modeles;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.NaturalId;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
    @NaturalId(mutable = true)
    private String email;

    @Column(length = 15, nullable = false)
    private String telephone;

    private String password;

    private LocalDate hiredDate;

    @Column(updatable = false)
    private LocalDate saveAt = LocalDate.now();

    @Enumerated(EnumType.STRING)
    @ElementCollection(targetClass = Roles.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "employe_roles", joinColumns = @JoinColumn(name = "employe_id"))
    @Column(name = "roles")
    private List<Roles> role;

    private boolean isEmployeActif;

    @OneToMany(mappedBy = "reportedBy")
    private List<BreakdownReport> listeBreakdownReported;

}
