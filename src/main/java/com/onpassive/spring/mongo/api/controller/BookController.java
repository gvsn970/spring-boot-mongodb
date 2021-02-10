package com.onpassive.spring.mongo.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.onpassive.spring.mongo.api.model.Book;
import com.onpassive.spring.mongo.api.service.BookService;

@RestController
public class BookController {


	@Autowired
	BookService bookService;
//	@Autowired
//    UsersCache usersCache;
	
	@PostMapping("/addBook")
	public String saveBook(@RequestBody Book book) {
		return bookService.saveBook(book);
	}
	
	@GetMapping("/findAllBooks")
	public List<Book> getBooks() {
		return bookService.getBooks();
	}
	
	@GetMapping("/findAllBooks/{id}")
	public Optional<Book> getBook(@PathVariable String id) {
		return bookService.getBook(id);
	}
	
	

	@DeleteMapping("/delete/{id}")
	@CacheEvict(value = "userCache")
	public String deleteBook(@PathVariable int id) {
		return bookService.deleteBook(id);
	}

}
