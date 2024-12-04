package com.lucassilveira.receitario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lucassilveira.receitario.model.Dish;
import com.lucassilveira.receitario.model.Recipe;

@Repository
public interface DishRepository extends JpaRepository<Dish, Integer> {
    void deleteByRecipe(Recipe recipe);
} // Dish Repository
