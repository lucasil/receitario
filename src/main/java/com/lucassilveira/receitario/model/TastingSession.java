package com.lucassilveira.receitario.model;

import java.time.LocalDate;
import java.util.List;

import io.micrometer.common.lang.Nullable;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "tasting_session")
public class TastingSession {

    // Attributes

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

    @Nullable
    @Column(name = "final_note")
    private double finalNote;

    // Relationship

    @ManyToOne(fetch = FetchType.EAGER,
                cascade = CascadeType.ALL)
    @JoinColumn(name = "taster_id")
    private Employee tasterEmployee;

    @ManyToOne(fetch = FetchType.EAGER,
                cascade = CascadeType.ALL)
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;

    @OneToMany(mappedBy = "tastingSession",
                fetch = FetchType.LAZY,
                cascade = CascadeType.ALL)
    private List<TastingNote> tastingNotes;

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getTastingDate() {
        return tastingDate;
    }

    public void setTastingDate(LocalDate tastingDate) {
        this.tastingDate = tastingDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public double getFinalNote() {
        return finalNote;
    }

    public void setFinalNote(double finalNote) {
        this.finalNote = finalNote;
    }

    public Employee getTasterEmployee() {
        return tasterEmployee;
    }

    public void setTasterEmployee(Employee tasterEmployee) {
        this.tasterEmployee = tasterEmployee;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public List<TastingNote> getTastingNotes() {
        return tastingNotes;
    }

    public void setTastingNotes(List<TastingNote> tastingNotes) {
        this.tastingNotes = tastingNotes;
    }

} // Tasting Session Entity
