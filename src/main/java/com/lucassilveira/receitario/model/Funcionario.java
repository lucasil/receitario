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
@Table(name = "Funcionario")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idFuncionario")
    private int id;
    
    @Column(name = "nome", nullable = false)
    private String nome;

    @Nullable
    @Column(name = "nome_fantasia")
    private String nomeFantasia;
    
    @Column(name = "rg", unique = true, nullable = false)
    private String rg;

    @Nullable
    @Column(name = "salario")
    private BigDecimal salario;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "data_adm", nullable = false)
    private LocalDate dataAdmissao;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idAtribuicao", nullable = false)
    private Atribuicao atribuicao;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idUsuario", referencedColumnName = "id")
    private Usuario usuario;

}