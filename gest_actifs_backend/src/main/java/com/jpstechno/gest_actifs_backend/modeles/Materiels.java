package com.jpstechno.gest_actifs_backend.modeles;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.NaturalId;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Materiels {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code", length = 15, nullable = false)
    @NaturalId
    private String interneCode;

    @Column(length = 50)
    private String appelation;

    private LocalDateTime savedAt;

    @ManyToOne
    private Categories categorie;

    @OneToMany(mappedBy = "materiel")
    private List<BreakdownReport> listeBreakdownReport;

}
