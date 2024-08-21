package com.sandbox.springboot.libraryV2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import model.Book;
import model.ResourceNotFoundException;

@Service
public class LibraryService {
	@Autowired
	private LibraryRepository libraryRepository;
	
	public List<Book> getAllBooks() {
		return libraryRepository.findAll();
	}
	
	public Book createBook(@RequestBody Book book) {
		return libraryRepository.save(book);
	}
	
	public Book updateBook(Book book) {
		return libraryRepository.save(book);
	}

	public Book getBookById(Long id) {
		return libraryRepository.findById(id).orElse(null);
	}
	
	public void deleteBook(Long id) {
		libraryRepository.deleteById(id);
	}
	
	public List<Book> getBooksByAuthor(String author) {
		return libraryRepository.findByAuthor(author);
	}
	
	public List<Book> getBooksByName(String name) {
		return libraryRepository.findByNameContaining(name);
	}
}
