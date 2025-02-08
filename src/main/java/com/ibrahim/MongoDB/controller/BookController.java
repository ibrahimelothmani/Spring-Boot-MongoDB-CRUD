package com.ibrahim.MongoDB.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.ibrahim.MongoDB.entity.Book;
import com.ibrahim.MongoDB.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class BookController {

    @Autowired
    BookRepository bookRepo;

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAllBooks() {

        try {
            List<Book> books = new ArrayList<Book>();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") Integer id) {

        Optional<Book> book = bookRepo.findById(String.valueOf(id));

        return book.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/books")
    public ResponseEntity<String> saveBook(@RequestBody Book book) {

        try {
            bookRepo.save(book);
            return new ResponseEntity<String>("Book saved", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Unable to save book", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping("/books/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable("id") Integer id, @RequestBody Book book) {

        Optional<Book> opt = bookRepo.getBookById(String.valueOf(id));

        if (opt.isPresent()) {
            Book book1 = opt.get();
            book1.setBookAuthor(book.getBookAuthor());
            book1.setBookName(book.getBookName());
            book1.setBookCost(book.getBookCost());
            return new ResponseEntity<>(bookRepo.save(book1), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<HttpStatus> deleteBook(@PathVariable("id") Integer id) {

        try {
            bookRepo.deleteById(String.valueOf(id));
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/books")
    public ResponseEntity<HttpStatus> deleteAllBooks() {

        try {
            bookRepo.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}