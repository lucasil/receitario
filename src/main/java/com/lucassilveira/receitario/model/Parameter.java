package com.lucassilveira.receitario.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

// OK

@Entity
@Table(name = "parameter")
public class Parameter {

    // Attributes

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotBlank(message = "O mês não pode estar em branco")
    @Column(name = "production_month")
    private int prodMonth;

    @NotBlank(message = "O ano não pode estar em branco")
    @Column(name = "production_year")
    private int prodYear;

    @Column(name = "production_qty")
    private int prodQty;

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProdMonth() {
        return prodMonth;
    }

    public void setProdMonth(int prodMonth) {
        this.prodMonth = prodMonth;
    }

    public int getProdYear() {
        return prodYear;
    }

    public void setProdYear(int prodYear) {
        this.prodYear = prodYear;
    }

    public int getProdQty() {
        return prodQty;
    }

    public void setProdQty(int prodQty) {
        this.prodQty = prodQty;
    }

} // Parameter Entity