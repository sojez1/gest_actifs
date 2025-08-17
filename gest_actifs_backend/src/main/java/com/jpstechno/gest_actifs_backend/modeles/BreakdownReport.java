package com.jpstechno.gest_actifs_backend.modeles;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Pour signaler une panne observee sur un materiel
 * 
 * @author Jean-Pierre S.
 * @since 2025-08
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BreakdownReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Employes reportedBy;

    @ManyToOne
    private Materiels materiel;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String reportDetails;

    @Enumerated(EnumType.STRING)
    private ReportStatus statut = ReportStatus.init;

}
