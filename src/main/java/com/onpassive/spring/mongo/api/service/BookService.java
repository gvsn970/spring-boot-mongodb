package com.onpassive.spring.mongo.api.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.onpassive.spring.mongo.api.controller.BookController;
import com.onpassive.spring.mongo.api.model.Book;
import com.onpassive.spring.mongo.api.repository.BookRepository;

@Service
public class BookService {

	Logger log = LoggerFactory.getLogger(BookService.class);

	@Autowired
	BookRepository bookRepository;

	public String saveBook(Book book) {
		log.debug("Request {}", book);
		bookRepository.save(book);
		log.debug("Response {}", book.getId());
		return "Added book with id : " + book.getId();
	}

	@Cacheable(cacheNames = { "userCache" })
	public List<Book> getBooks() {
		System.out.println("Hit DB 1st time in getUsers()");
		log.debug("Request {}");
		log.debug("Response {}");
		return bookRepository.findAll();
	}

	@Cacheable(value = "userCache", key = "#id", unless = "#result==null")
	public Optional<Book> getBook(String id) {
		System.out.println("Hit DB 1st time in getUser()");
		// return usersCache.getBooksById(id);
		return bookRepository.findById(id);
	}
	
	@CacheEvict(value = "userCache")
	public String deleteBook(@PathVariable int id) {
		bookRepository.deleteById(id);
		return "book deleted with id : " + id;
	}

}
