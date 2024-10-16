package com.lucassilveira.receitario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lucassilveira.receitario.model.DishCategory;

@Repository
public interface DishCategoryRepository extends JpaRepository<DishCategory, Integer> {

} // Dish Category Repository