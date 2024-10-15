package com.lucassilveira.receitario.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// OK

@Entity
@Table(name = "parameter")
public class Parameter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "production_month")
    private int prodMonth;

    @Column(name = "production_year")
    private int prodYear;

    @Column(name = "production_qty")
    private int prodQty;
}