package com.lucassilveira.receitario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lucassilveira.receitario.model.MediaType;

@Repository
public interface MediaTypeRepository extends JpaRepository<MediaType, Integer> {

} // Media Type Repository
