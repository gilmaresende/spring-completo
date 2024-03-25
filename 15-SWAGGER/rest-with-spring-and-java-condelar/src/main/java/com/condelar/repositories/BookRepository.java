package com.condelar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.condelar.model.Book;

public interface BookRepository extends JpaRepository<Book, Long>{

}
