package com.api.books.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.books.model.Books;

public interface BookRepository extends JpaRepository<Books, Integer>{
  public Books findById(int id);
  public Books findByAuthor(String name);
  public Books findByBookname(String name);
}
