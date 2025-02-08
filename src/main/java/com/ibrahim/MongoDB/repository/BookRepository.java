package com.ibrahim.MongoDB.repository;

import com.ibrahim.MongoDB.entity.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends MongoRepository<Book, String> {

    Optional<Book> getBookById(String id);

}
