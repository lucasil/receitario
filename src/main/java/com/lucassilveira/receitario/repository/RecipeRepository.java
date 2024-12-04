package com.lucassilveira.receitario.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lucassilveira.receitario.model.Employee;
import com.lucassilveira.receitario.model.Recipe;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Integer> {
    List<Recipe> findByChefEmployee(Employee chefEmployee);
} // Recipe Repository
