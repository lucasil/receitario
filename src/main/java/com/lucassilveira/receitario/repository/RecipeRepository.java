package com.lucassilveira.receitario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lucassilveira.receitario.model.Recipe;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Integer> {

} // Recipe Repository
