package com.lucassilveira.receitario.model;

import java.time.LocalDate;

import io.micrometer.common.lang.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "tasting_session")
public class TastingSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Temporal(TemporalType.DATE)
    @Column(name = "tasting_date")
    private LocalDate tastingDate;

    @Nullable
    @Column(name = "comment")
    private String comment;

    @Column(name = "final_note")
    private double finalNote;
}
