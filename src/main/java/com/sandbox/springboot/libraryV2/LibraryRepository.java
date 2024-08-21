package com.sandbox.springboot.libraryV2;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import model.Book;

@Repository
public interface LibraryRepository extends JpaRepository<Book, Long> {
	List<Book> findByAuthor(String Author);
	List<Book> findByNameContaining(String Name);	
}