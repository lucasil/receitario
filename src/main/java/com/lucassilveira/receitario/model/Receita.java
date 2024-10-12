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
@Table(name = "Receita")
public class Receita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idReceita")
    private int id;

    @Column(name = "nome_receita")
    private String nomeReceita;

    @Column(name = "modo_preparo")
    private String modoPreparo;

    @Column(name = "num_porcao")
    private int numPorcao;

    @Column(name = "tempo_preparo")
    private int tempoPreparo;

    @Column(name = "ind_inedita")
    private boolean inedita;

    @Temporal(TemporalType.DATE )
    @Column(name = "data_inclusao")
    private LocalDate dataInclusao;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idFuncionario")
    private Funcionario funcionario;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idCategoria_Receita")
    private Categoria categoria;
}
