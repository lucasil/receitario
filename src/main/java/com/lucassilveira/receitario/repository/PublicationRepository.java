package com.lucassilveira.receitario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lucassilveira.receitario.model.Publication;

@Repository
public interface PublicationRepository extends JpaRepository<Publication, Integer> {

} // Publication Repository
