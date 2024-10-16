package com.lucassilveira.receitario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lucassilveira.receitario.model.TastingNote;

@Repository
public interface TastingNoteRepository extends JpaRepository<TastingNote, Integer> {

} // Tasting Note Repository
