package com.onpassive.spring.mongo.api.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.onpassive.spring.mongo.api.model.Book;

public interface BookRepository extends MongoRepository<Book, Integer>{
	
	Optional<Book> findById(String id);

}
