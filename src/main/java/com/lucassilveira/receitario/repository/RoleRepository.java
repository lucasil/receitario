package com.lucassilveira.receitario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lucassilveira.receitario.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findById(int id);
    Role findByName(String name);
} // Role Repository
