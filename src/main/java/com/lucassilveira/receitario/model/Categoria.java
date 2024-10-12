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
@Table(name = "Categoria_Receita")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCategoria_Receita")
    private int id;

    @Column(name = "nome_categoria")
    private String nomeCategoria;

    @Column(name = "descricao_categoria")
    private String descricaoCategoria;

    @OneToMany(mappedBy = "nome_categoria")
    private List<Receita> receitas;
}
