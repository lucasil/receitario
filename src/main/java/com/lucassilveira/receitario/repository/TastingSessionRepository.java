package com.lucassilveira.receitario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lucassilveira.receitario.model.TastingSession;

@Repository
public interface TastingSessionRepository extends JpaRepository<TastingSession, Integer> {

} // Tasting Session Repository
