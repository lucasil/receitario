package com.lucassilveira.receitario.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "publication")
public class Publication {

    // Attributes

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "recipe_qty")
    private int recipeQty;

    @Temporal(TemporalType.DATE)
    @Column(name = "publication_date")
    private LocalDate publiDate;

    // Relationship

    @ManyToOne(fetch = FetchType.EAGER,
                optional = true)
    @JoinColumn(name = "book_id", 
                nullable = true)
    private Book book;

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

    public int getRecipeQty() {
        return recipeQty;
    }

    public void setRecipeQty(int recipeQty) {
        this.recipeQty = recipeQty;
    }

    public LocalDate getPubliDate() {
        return publiDate;
    }

    public void setPubliDate(LocalDate publiDate) {
        this.publiDate = publiDate;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

} // Publication Entity
