package com.lucassilveira.receitario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lucassilveira.receitario.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

} // Book Repository
