package com.lucassilveira.receitario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lucassilveira.receitario.model.Ingredient;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Integer> {

} // Ingredient Repository
