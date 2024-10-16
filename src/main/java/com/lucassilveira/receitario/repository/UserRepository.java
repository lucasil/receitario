package com.lucassilveira.receitario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lucassilveira.receitario.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

} // User Repository
