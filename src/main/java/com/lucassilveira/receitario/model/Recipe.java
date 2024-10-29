package com.lucassilveira.receitario.model;

import java.time.LocalDate;
import java.util.List;

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
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "recipe")
public class Recipe {

    // Attributes

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotBlank(message = "Insira o nome da receita")
    @Column(name = "name")
    private String name;

    @NotBlank(message = "Insira o nome do ingrediente")
    @Column(name = "preparation_method")
    private String preparationMethod;

    @NotBlank(message = "Insira o número de porções")
    @Column(name = "portion")
    private int portion;

    @NotBlank(message = "Insira o tempo de preparo")
    @Column(name = "preparation_time")
    private int preparationTime;

    @Column(name = "unpublished")
    private boolean unpublished;

    @Temporal(TemporalType.DATE )
    @Column(name = "inclusion_date")
    private LocalDate inclusionDate;

    // Getters and Setters

    @ManyToOne(fetch = FetchType.EAGER,
                optional = true)
    @JoinColumn(name = "chef_id", 
                nullable = true)
    private Employee chefEmployee;

    @OneToMany(mappedBy = "recipe",
                fetch = FetchType.LAZY)
    private List<Publication> publications;
    
    @OneToMany(mappedBy = "recipe",
                fetch = FetchType.LAZY)
    private List<TastingSession> tastingSessions;

    @OneToMany(mappedBy = "recipe",
                fetch = FetchType.LAZY)
    private List<RecipeMedia> recipeMedias;

    @OneToMany(mappedBy = "recipe",
                fetch = FetchType.LAZY)
    private List<Dish> dishes;

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

    public String getPreparationMethod() {
        return preparationMethod;
    }

    public void setPreparationMethod(String preparationMethod) {
        this.preparationMethod = preparationMethod;
    }

    public int getPortion() {
        return portion;
    }

    public void setPortion(int portion) {
        this.portion = portion;
    }

    public int getPreparationTime() {
        return preparationTime;
    }

    public void setPreparationTime(int preparationTime) {
        this.preparationTime = preparationTime;
    }

    public boolean isUnpublished() {
        return unpublished;
    }

    public void setUnpublished(boolean unpublished) {
        this.unpublished = unpublished;
    }

    public LocalDate getInclusionDate() {
        return inclusionDate;
    }

    public void setInclusionDate(LocalDate inclusionDate) {
        this.inclusionDate = inclusionDate;
    }

    public Employee getChefEmployee() {
        return chefEmployee;
    }

    public void setChefEmployee(Employee chefEmployee) {
        this.chefEmployee = chefEmployee;
    }

    public List<Publication> getPublications() {
        return publications;
    }

    public void setPublications(List<Publication> publications) {
        this.publications = publications;
    }

    public List<TastingSession> getTastingSessions() {
        return tastingSessions;
    }

    public void setTastingSessions(List<TastingSession> tastingSessions) {
        this.tastingSessions = tastingSessions;
    }

    public List<RecipeMedia> getRecipeMedias() {
        return recipeMedias;
    }

    public void setRecipeMedias(List<RecipeMedia> recipeMedias) {
        this.recipeMedias = recipeMedias;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

} // Recipe Entity
