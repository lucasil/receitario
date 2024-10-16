package com.lucassilveira.receitario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lucassilveira.receitario.model.Parameter;

@Repository
public interface ParameterRepository extends JpaRepository<Parameter, Integer> {

} // Parameter Repository
