package com.onpassive.spring.mongo.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.onpassive.spring.mongo.api.model.Book;

public interface BookRepository extends MongoRepository<Book, Integer>{

}
