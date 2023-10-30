package com.api.books.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.books.model.Books;
import com.api.books.repository.BookRepository;

@Component
public class BookService {
   
//	private static List<Books> list=new ArrayList<>();
//	
//	static {
//		list.add(new Books(123,"Java","Ashish"));
//		list.add(new Books(124,"Java 4","Ashish Yadav"));
//		list.add(new Books(125,"Java 3","Anshu"));
//		list.add(new Books(126,"Java 2","Abhi"));
//		list.add(new Books(127,"Java 1","Anku"));
//	}
	@Autowired
	BookRepository bookRepository;
	
	public List<Books> getAllBooks(){
		List<Books> list=bookRepository.findAll();
		return list;
	}
	
	public Books getBookById(int id){
		
		//Optional<Books> book= Optional.of(list.stream().filter(e->e.getId()==id).findFirst().get());
		Books book= bookRepository.findById(id);
		return book;
	}
	public Books getBookByAuthor(String author){
		
		//Optional<Books> book= Optional.of(list.stream().filter(e->e.getAuthor().equals(author)).findFirst().get());
		Books book= bookRepository.findByAuthor(author);
		return book;
	}
	
	public Books getBookByName(String name){
		
		//Optional<Books> book= Optional.of(list.stream().filter(e->e.getBookname().equals(name)).findFirst().get());
		Books book= bookRepository.findByBookname(name);
		return book;
	}
	
	public void addBook(Books b) {
		//list.add(b);
		bookRepository.save(b);
	}
	
	public void deleteBook(int bid) {
		//list =list.stream().filter(book->book.getId()!=bid).collect(Collectors.toList());
		bookRepository.deleteById(bid);
	}
	
	public void updateBook(Books book, int bookId) {
//		list=list.stream().map(b->{
//			if(b.getId()==bookId) {
//				b.setBookname(book.getBookname());
//				b.setAuthor(book.getAuthor());
//			}
//			return b;
//		}).collect(Collectors.toList());
		
		book.setId(bookId);
		bookRepository.save(book);
	}
	
}
