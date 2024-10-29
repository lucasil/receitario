package com.lucassilveira.receitario.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "tasting_note")
public class TastingNote {

    // Attributes

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotBlank(message = "Insira a nota")
    @Column(name = "note")
    private double note;

    // Relationship

    @ManyToOne(fetch = FetchType.EAGER,
                optional = true)
    @JoinColumn(name = "tasting_category_id", 
                nullable = true)
    private TastingCategory tastingCategory;

    @ManyToOne(fetch = FetchType.EAGER,
                optional = true)
    @JoinColumn(name = "tasting_session_id", 
                nullable = true)
    private TastingSession tastingSession;

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getNote() {
        return note;
    }

    public void setNote(double note) {
        this.note = note;
    }

    public TastingCategory getTastingCategory() {
        return tastingCategory;
    }

    public void setTastingCategory(TastingCategory tastingCategory) {
        this.tastingCategory = tastingCategory;
    }

    public TastingSession getTastingSession() {
        return tastingSession;
    }

    public void setTastingSession(TastingSession tastingSession) {
        this.tastingSession = tastingSession;
    }

} // Tasting Note Entity
