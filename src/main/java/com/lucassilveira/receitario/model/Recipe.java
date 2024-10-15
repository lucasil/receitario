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
@Table(name = "recipe")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "preparation_method")
    private String preparationMethod;

    @Column(name = "portion")
    private int portion;

    @Column(name = "preparation_time")
    private int preparationTime;

    @Column(name = "unpublished")
    private boolean unpublished;

    @Temporal(TemporalType.DATE )
    @Column(name = "inclusion_date")
    private LocalDate inclusionDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "recipe_category_id")
    private RecipeCategory recipeCategory;
}
