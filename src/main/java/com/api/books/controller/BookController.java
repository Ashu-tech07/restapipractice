package com.api.books.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.books.model.Books;
import com.api.books.service.BookService;

@RestController
public class BookController {
	@Autowired
	BookService bookService;
	
	@GetMapping(value="/books")
	public List<Books> getBooks() {
		
		return this.bookService.getAllBooks();
	}
	
	@GetMapping(value="/books/{id}")
	public Books getBook(@PathVariable("id") int id) {
		return this.bookService.getBookById(id);
	}
	
	@GetMapping(value="/books/ba/{author}")
	public Books getAuthor(@PathVariable("author") String author) {
		return this.bookService.getBookByAuthor(author);
	}
	
	@GetMapping(value="/books/bn/{name}")
	public Books getName(@PathVariable("name") String name) {
		return this.bookService.getBookByName(name);
	}
	
	@PostMapping(value="/books")
	public void addBook(@RequestBody Books book) {
		 this.bookService.addBook(book);
	}
	@DeleteMapping(value="/books/{bookid}")
	public void deleteBook(@PathVariable("bookid") int bookid) {
		this.bookService.deleteBook(bookid);
	}
	
	@PutMapping(value="/books/{bookid}")
	public void updateBook(@RequestBody Books book,@PathVariable("bookid") int bookid) {
		this.bookService.updateBook(book, bookid);
	}

}
