package com.lucassilveira.receitario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lucassilveira.receitario.model.RecipeMedia;

@Repository
public interface RecipeMediaRepository extends JpaRepository<RecipeMedia, Integer> {

} // Recipe Media Repository
