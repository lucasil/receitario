package com.lucassilveira.receitario.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "media_type")
public class MediaType {

    // Attributes

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "description")
    private String description;

    // Relationship

    @OneToMany(mappedBy = "mediaType",
                fetch = FetchType.LAZY,
                cascade = CascadeType.ALL)
    private List<RecipeMedia> recipeMedias;

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<RecipeMedia> getRecipeMedias() {
        return recipeMedias;
    }

    public void setRecipeMedias(List<RecipeMedia> recipeMedias) {
        this.recipeMedias = recipeMedias;
    }

} // MediaType Entity
