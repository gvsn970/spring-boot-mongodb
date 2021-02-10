/*
 * package com.onpassive.spring.mongo.api.configure;
 * 
 * import java.util.Optional;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.cache.annotation.Cacheable; import
 * org.springframework.stereotype.Component;
 * 
 * import com.onpassive.spring.mongo.api.model.Book; import
 * com.onpassive.spring.mongo.api.repository.BookRepository;
 * 
 * @Component public class UsersCache {
 * 
 * @Autowired BookRepository usersRepository;
 * 
 * @Cacheable(value = "usersCache", key = "#id") public Optional<Book>
 * getBooksById(String id) {
 * 
 * System.out.println("Retrieving from Database for name: " +
 * usersRepository.findById(id)); return usersRepository.findById(id); } }
 */