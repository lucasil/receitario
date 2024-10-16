package com.lucassilveira.receitario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lucassilveira.receitario.model.TastingCategory;

@Repository
public interface TastingCategoryRepository extends JpaRepository<TastingCategory, Integer> {

} // Tasting Category Repository
