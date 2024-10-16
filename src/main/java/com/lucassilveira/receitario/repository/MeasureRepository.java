package com.lucassilveira.receitario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lucassilveira.receitario.model.Measure;

@Repository
public interface MeasureRepository extends JpaRepository<Measure, Integer> {

} // Measure Repository
