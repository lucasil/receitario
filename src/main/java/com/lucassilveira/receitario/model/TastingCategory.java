package com.lucassilveira.receitario.model;

import java.util.List;

import io.micrometer.common.lang.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "tasting_category")
public class TastingCategory {

    // Attributes

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotBlank(message = "Insira o nome de uma categoria")
    @Column(name = "name", 
            unique = true)
    private String name;

    @Nullable
    @Column(name = "description")
    private String description;

    // Relationship

    @OneToMany(mappedBy = "tastingCategory",
                fetch = FetchType.LAZY)
    private List<TastingNote> tastingNotes;

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<TastingNote> getTastingNotes() {
        return tastingNotes;
    }

    public void setTastingNotes(List<TastingNote> tastingNotes) {
        this.tastingNotes = tastingNotes;
    }

} // Tasting Category Entity
