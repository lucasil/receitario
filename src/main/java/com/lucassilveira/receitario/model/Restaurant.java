package com.lucassilveira.receitario.model;

import java.util.List;

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
@Table(name = "restaurant")
public class Restaurant {

    // Attributes

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotBlank(message = "Insira o nome do restaurante")
    @Column(name = "name")
    private String name;

    // Relationship

    @OneToMany(mappedBy = "restaurant",
                fetch = FetchType.LAZY)
    private List<WorkingReference> references;

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

    public List<WorkingReference> getReferences() {
        return references;
    }

    public void setReferences(List<WorkingReference> references) {
        this.references = references;
    }
    
} // Restaurant Entity
