package com.lucassilveira.receitario.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Atribuicao")
public class Atribuicao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAtribuicao")
    private int id;

    @Column(name = "atribuicao", nullable = false)
    private String atribuicao;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @OneToMany(mappedBy = "atribuicao")
    private List<Funcionario> funcionarios;

}