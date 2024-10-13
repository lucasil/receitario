package com.lucassilveira.receitario.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import io.micrometer.common.lang.Nullable;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name = "name")
    private String name;

    @Nullable
    @Column(name = "trade_name")
    private String tradeName;
    
    @Column(name = "rg", unique = true)
    private String rg;

    @Nullable
    @Column(name = "salary")
    private BigDecimal salary;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "adm_date")
    private LocalDate admissionDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    private Role role;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idUsuario", referencedColumnName = "id")
    private User usuario;

}