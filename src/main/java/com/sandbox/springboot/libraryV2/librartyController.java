package com.sandbox.springboot.libraryV2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.Book;
import model.ResourceNotFoundException;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class librartyController {
	
	@Autowired
	private LibraryRepository libraryRepository;
	@Autowired
	private LibraryService libraryService;
	
	//get all books	
	@GetMapping("/books")
	public List<Book> getAllBooks() {
		return libraryService.getAllBooks();
	}
	
	//create book rest api
	@PostMapping("/books")
	public Book createBook(@RequestBody Book book) {
		return libraryService.createBook(book);
	}
	
	//get book by id rest api
	@GetMapping("/books/{id}")
	public Book getBookById(@PathVariable("id") Long id) {
		if (id == null) {
			throw new IllegalArgumentException("ID cannot be null");
		}
		return libraryService.getBookById(id);
	}
	
	//get book by author rest api
	@GetMapping("/books/author/{author}")
	public List<Book> getBookByAuthor(@PathVariable("author") String author) {
		System.out.println("author=" + author);
		if (author == null) {
			throw new IllegalArgumentException("ID cannot be null");
		}
		return libraryService.getBooksByAuthor(author);
	}
		
	//get book by name rest api
	@GetMapping("/books/name/{name}")
	public List<Book> getBookByName(@PathVariable("name") String name) {
		System.out.println("name=" + name);
		if (name == null) {
			throw new IllegalArgumentException("Name cannot be null");
		}			
					
		return libraryService.getBooksByName(name);
	}
		
	//update book rest api
	@PutMapping("/books/{id}")
	public ResponseEntity<Book> updateBook(@PathVariable("id") Long id, @RequestBody Book bookDetails) {
		Book book = libraryService.getBookById(id);

		book.setName(bookDetails.getName());
		book.setAuthor(bookDetails.getAuthor());
		book.setLanguage(bookDetails.getLanguage());
		book.setRating(bookDetails.getRating());
		
		Book updatedBook = libraryService.updateBook(book);
		return ResponseEntity.ok(updatedBook);	
	}
	
	//delete book rest api
	@DeleteMapping("/books/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteBook(@PathVariable("id") Long id) {
		Book book = libraryRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Book does not exist with id: " + id));
		
		libraryService.deleteBook(id);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
