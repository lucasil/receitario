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
@Table(name = "Referencia")
public class Referencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idReferencia")
    private int id;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_inic", nullable = false)
    private LocalDate dataInic;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_fim")
    private LocalDate dataFim;

    @Column(name = "telefone_contato")
    private String telContato;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idFuncionario", nullable = false)
    private Funcionario funcionario;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idRestaurante")
    private Restaurante restaurante;
}
