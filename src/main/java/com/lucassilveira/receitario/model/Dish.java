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
@Table(name = "dish")
public class Dish {

    // Attributes

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotBlank(message = "Insira a quantidade de um ingrediente")
    @Column(name = "qty")
    private double qty;

    // Relationship

    @ManyToOne(fetch = FetchType.EAGER, 
                optional = true)
    @JoinColumn(name = "measure_id", 
                nullable = true)
    private Measure measure;

    @ManyToOne(fetch = FetchType.EAGER,
                optional = true)
    @JoinColumn(name = "ingredient_id",
                nullable = true)
    private Ingredient ingredient;

    @ManyToOne(fetch = FetchType.EAGER,
                optional = true)
    @JoinColumn(name = "dish_category", 
                nullable = true)
    private DishCategory dishCategory;

    @ManyToOne(fetch = FetchType.EAGER,
                optional = true)
    @JoinColumn(name = "recipe_id",
                nullable = true)
    private Recipe recipe;

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getQty() {
        return qty;
    }

    public void setQty(double qty) {
        this.qty = qty;
    }

    public Measure getMeasure() {
        return measure;
    }

    public void setMeasure(Measure measure) {
        this.measure = measure;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public DishCategory getDishCategory() {
        return dishCategory;
    }

    public void setDishCategory(DishCategory dishCategory) {
        this.dishCategory = dishCategory;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

} // Dish Entity
