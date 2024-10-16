package com.lucassilveira.receitario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lucassilveira.receitario.model.WorkingReference;

@Repository
public interface WorkingReferenceRepository extends JpaRepository<WorkingReference, Integer> {

} // Working Reference Repository
