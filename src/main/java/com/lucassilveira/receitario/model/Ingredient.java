package com.lucassilveira.receitario.model;

import java.util.List;

import io.micrometer.common.lang.Nullable;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "ingredient")
public class Ingredient {

    // Attributes

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotBlank(message = "Insira um ingrediente")
    @Size(min = 3,
            max = 100,
            message = "O ingrediente deve ter entre 3 e 100 caracteres")
    @Column(name = "name", unique = true)
    private String name;

    @Nullable
    @Size(max = 500, 
            message = "A descrição não deve ter mais de 500 caracteres")
    @Column(name = "decription")
    private String description;

    // Relationship

    @OneToMany(mappedBy = "ingredient",
                fetch = FetchType.LAZY,
                cascade = CascadeType.ALL)
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

} // Ingredient Entity
